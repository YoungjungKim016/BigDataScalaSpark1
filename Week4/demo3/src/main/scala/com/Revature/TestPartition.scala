package com.Revature

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object TestPartition {
  def main(args: Array[String]): Unit = {
    // create a spark session
    // for Windows
    //System.setProperty("hadoop.home.dir", "C:\\winutils")
    System.setProperty("hadoop.home.dir", "C:\\hadoop")
    val spark = SparkSession
      .builder
      .appName("hello hive")
      .config("spark.master", "local[*]")
      .enableHiveSupport()
      .getOrCreate()
    Logger.getLogger("org").setLevel(Level.ERROR)
    println("created spark session")
    spark.sparkContext.setLogLevel("ERROR")
    spark.sql("Set hive.exec.dynamic.partition.mode=nonstrict")
    spark.sql("DROP TABLE IF EXISTS dem")
    spark.sql("create table dem(id INT,age INT, state STRING) partitioned by (gender STRING) row format delimited fields terminated by ',' stored as textfile")
    spark.sql("DROP table IF EXISTS demrg")
    spark.sql("create table demrg(id INT,gender STRING,age INT, state STRING)row format delimited fields terminated by ',' stored as textfile")
    spark.sql("LOAD DATA LOCAL INPATH 'Demo.txt' INTO TABLE demrg")
    spark.sql("insert overwrite table Dem partition(gender) select id,age,state,gender from DemRg")
    spark.sql("SELECT Count(*) AS TOTALCOUNT FROM demrg").show()
    spark.close()
  }
}
