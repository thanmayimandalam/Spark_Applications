package com.spark.applications

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

/**
  * Created by Thanu on 6/21/2018.
  */
object InactiveCustomersDF {

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
    val OrdersMAp = OrdersRDD.map(rec => (rec.split(",")(2))).toDF("Order_CustomerID")
    OrdersMAp.registerTempTable("Orders")
    val customersRDD = sc.textFile("/user/spark/app/customers/part-00000")

    val customersMap = customersRDD.map(rec => { (rec.split(",")(0), rec.split(",")(1),rec.split(",")(2)) }).toDF("Customer_ID","CustomerFname","CustomerLname")
    customersMap.registerTempTable("Customers")


    hiveContext.sql("select CustomerFname,CustomerLname " +
      "from Customers left outer join Orders " +
      "on Customer_ID = Order_CustomerID " +
      "where Order_CustomerID is null " +
      "order by CustomerFname,CustomerLname ").show
  }

}
