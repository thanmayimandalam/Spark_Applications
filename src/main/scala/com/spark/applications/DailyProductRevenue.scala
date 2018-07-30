package com.spark.applications

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Thanu on 6/19/2018.
  */
object DailyProductRevenue {
  def main(args: Array[String]): Unit = {
    /*    SETTING UP SPARK CONFIGURATION   */
    /*    SETTING UP SPARK CONFIGURATION   */
    val conf = new SparkConf()
    conf.setAppName("Product Revenue DataFrames")
    conf.setMaster("yarn-client")


    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")

    /*  Reading Data from HDFS  */
    val OrdersRDD = sc.textFile("/user/spark/app/orders/part-00000")
    val productRDD = sc.textFile("/user/spark/app/products/part-00000")
    val OrderItems = sc.textFile("/user/spark/app/order_items/part-00000")

    /*    ACCUMULATORS    */
    val orderCompleted = sc.accumulator(0,"Orders Completed Count")
    val orderNonCompleted = sc.accumulator(0,"Orders in-completed Count")

    /*    FILTERING DATA    */
    val ordersFilteredOnCompleted = OrdersRDD.filter( order => {

      val isCompleted = order.split(",")(3) == "COMPLETED" || order.split(",")(3) == "CLOSED"

      if(isCompleted)
        orderCompleted += 1
      else
        orderNonCompleted +=1

      isCompleted
    })

    // orderMap --> (orderID, orderDate)
    val orderMap = OrdersRDD.map(order => {
      (order.split(",")(0).toInt,order.split(",")(1))
    })

    // orderItemMap -> (orderID, (productID, order_itemSubTotal))
    val orderItemMap = OrderItems.map(orderItem => {
      (orderItem.split(",")(1).toInt, (orderItem.split(",")(2).toInt, orderItem.split(",")(4).toFloat)) })

    /*    JOINING (K,V)     */
    val ordersJoin = orderMap.join(orderItemMap)
    val ordersLeftJoin = orderMap.leftOuterJoin(orderItemMap)

    // taking orderItemMap as a reference and filtering out the rejected orders from order items

    val ordersRejectedMap = ordersLeftJoin.filter( missingorder =>  missingorder._2._2 == None)
    val orderJoinMap = ordersJoin.map( order => ((order._2._1, order._2._2._1),(order. _2._2._2)))

    /*    REDUCE-BY-KEY      */
    // dailyRevenuePerProductID(K,V) --> ((orderDate, productID), sum(order_itemSubTotal))
    val dailyRevenuePerProductID = orderJoinMap.reduceByKey((total, revenue) => total + revenue)

    // dailyRevenueABK(K,V) --> ((orderDate, productID), (sum(order_itemSubTotal), count(productID)))
    val dailyRevenueABK = orderJoinMap.aggregateByKey((0.0,0))(
      (i,revenue) => (i._1 + revenue, i._2 + 2),
      (i1,i2) => (i1._1 + i2._1, i1._2 + i2._2)
    )
    dailyRevenueABK.take(100).foreach(println)


  }

}
