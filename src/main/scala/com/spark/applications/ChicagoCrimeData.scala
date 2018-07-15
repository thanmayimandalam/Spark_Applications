package com.spark.applications

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by adity on 6/20/2018.
  */
object ChicagoCrimeData {
/*


  def main(args: Array[String]): Unit = {


    /*    SETTING UP SPARK CONFIGURATION   */
    val conf = new SparkConf()
    conf.setAppName("Product Revenue DataFrames")
    conf.setMaster("yarn-client")

    val sc = new SparkContext(conf)

    /*    SETTING UP HIVE CONTEXT   */
    val hiveContext = new HiveContext(sc)
    import hiveContext.implicits._

   val chicagoCrimeRaw = sc.textFile("/user/spark/ChicagoCrime/Crimes_-_2018.csv")
    val ccHeader = chicagoCrimeRaw.first()
    val ccwithoutHeader = chicagoCrimeRaw.filter(rec => rec!= ccHeader)
    val Datapattern = ccwithoutHeader.map(rec => {
      val R = rec.split(",")
      val D = R(2).split(" ")(0)
      val M = D.split("/")(2) + D.split("/")(0)
      ((M.toInt,R(5)),1)
    }).reduceByKey((AC,Total) => AC + Total)

    val SortbyTypeMonth = Datapattern.map(rec => {

      ((rec._1._1,-rec._2),rec._1._1 + "\t" + rec._2 + "\t" + rec._1._2 )}).sortByKey().map(rec => rec._2)







    val ChicagoCrimeResult = ccwithoutHeader.filter(rec => (rec.split(",(?=(?;[^\"]*"[^\"]*\")*[^\"]*$)", -1)(7) == "RESIDENCE")).
    map(r => (r.split(",(?=(?;[^\"]*"[^\"]*\")*[^\"]*$)", -1)(5)),1)).
      reduceByKey((AC,total) => AC + total ).
        sortBykey(false).
        take(3)

    val ChicagoCrimeRaw = sc.textFile("/user/spark/ChicagoCrime/Crimes_-_2018.csv")
    val CCHeader = chicagoCrimeRaw.first()
    val CCwithoutHeader = chicagoCrimeRaw.filter(rec => rec!= ccHeader)
    val CrimedataMap = ccwithoutHeader.
      map(rec => {val r = rec.split(",(?=(?;[^\"]*"[^\"]*\")*[^\"]*$)", -1)((5)(7))}).toDF("Crime Type","Location")

    CrimedataMap.registerTempTable("CrimeTable")
    sqlContext.sql("select * from (" +
      "select Crime Type," +
      "count(1) CrimeCount" +
      "from CrimeTable" +
      "where Location = 'RESIDENCE' " +
      "group by Crime Type" +
      "order by CrimeCount desc") P " +
      "limit 3").save(File path,"file type")


    val wordcount = sc.textFile("")
    val WordFlatMap = wordcount.flatMap(rec => rec.split(" ")).map(rec => ((rec),1)).reduceByKey((AC,Total) => AC + Total).
      toDF("WOrd","COUNT")

    /*write.Json or save("File path",File Type)*/

  }

*/
}
