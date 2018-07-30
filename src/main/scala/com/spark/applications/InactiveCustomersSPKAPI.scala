package com.spark.applications

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

/**
  * Created by Thanu on 6/21/2018.
  */
object InactiveCustomersSPKAPI {

  def main(args: Array[String]): Unit = {

    /*    SETTING UP SPARK CONFIGURATION   */
    val conf = new SparkConf()
    conf.setAppName("Product Revenue DataFrames")
    conf.setMaster("yarn-client")

    val sc = new SparkContext(conf)

    /*    SETTING UP HIVE CONTEXT   */
    val hiveContext = new HiveContext(sc)
    import hiveContext.implicits._

    val OrdersRDD = sc.textFile("/user/spark/app/orders/part-00000")
    /*Key value pairs ((Order_customerID,1)) */
    val OrdersMAp = OrdersRDD.map(rec => ((rec.split(",")(2)), 1))
    val customersRDD = sc.textFile("/user/spark/app/customers/part-00000")
    /* */
    val customersMap = customersRDD.map(rec => {(rec.split(",")(0),(rec.split(",")(1),rec.split(",")(2)))})
    val leftouterJoin = customersMap.leftOuterJoin(OrdersMAp)

    val leftouterJoinMap = leftouterJoin.filter(rec => (rec._2._2 == None)).map(rec =>(rec._2._1)).sortByKey()

    val finalResult = leftouterJoinMap.map(rec => rec._1 + "," + rec._2).saveAsTextFile("/user/spark/app/result/inactiveCustomers")





  }
}
