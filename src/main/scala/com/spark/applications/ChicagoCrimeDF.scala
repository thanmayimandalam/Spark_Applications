package com.spark.applications

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

/**
  * Created by adity on 6/21/2018.
  */
object ChicagoCrimeDF {

  def main(args: Array[String]): Unit = {

    /*    SETTING UP SPARK CONFIGURATION   */
    val conf = new SparkConf()
    conf.setAppName("Product Revenue DataFrames")
    conf.setMaster("yarn-client")

    val sc = new SparkContext(conf)

    /*    SETTING UP HIVE CONTEXT   */
    val hiveContext = new HiveContext(sc)
    import hiveContext.implicits._

    val ChicagoCrimeRaw = sc.textFile("/user/spark/ChicagoCrime/Crimes_-_2018.csv")
    val CCHeader = ChicagoCrimeRaw.first()
    val CCwithoutHeader = ChicagoCrimeRaw.filter(rec => rec!= CCHeader)
    val CCDF = CCwithoutHeader.map(rec => (rec.split(",")(2) , rec.split(",")(5))).toDF("CrimeDate","Crime Type")

    CCDF.registerTempTable("CrimeCount")

    hiveContext.sql("select * from CrimeCount").show
    hiveContext.sql("select cast(concat(substr(CrimeDate,7,4),substr(CrimeDate,0,2)) as int) CrimeMonth, " +
      "count(1) CrimeCountPerTypePerMonth, " +
      "Crime Type " +
      "from CrimeCount " +
      "group by cast(concat(substr(CrimeDate,7,4),substr(CrimeDate,0,2)) as int),Crime Type " +
      "order by CrimeMonth, CrimeCountPerTypePerMonth desc ")

  }


}
