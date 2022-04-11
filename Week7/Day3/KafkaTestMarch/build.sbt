version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.10"
lazy val root = (project in file("."))
  .settings(
    name := "KafkaTest"
  )

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.1.0"
//libraryDependencies += "org.apache.spark" %% "spark-core" % "3.2.0"
//libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.0"
//libraryDependencies += "org.apache.spark" %% "spark-hive" % "3.2.0"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
