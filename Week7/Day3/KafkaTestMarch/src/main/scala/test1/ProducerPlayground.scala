package test1

import java.util.Properties
//import collection.mutable.ListBuffer
//import java.io._
//import scala.io._
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.{IntegerSerializer, StringSerializer}


object ProducerPlayground extends App{
  val topicName = "sql_dolphins3"

  val producerProperties = new Properties()
  producerProperties.setProperty(
    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"
  )
  producerProperties.setProperty(
    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[IntegerSerializer].getName
  )
  producerProperties.setProperty(
    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName
  )

  val producer = new KafkaProducer[Int, String](producerProperties)

  val transaction="12345"

  //SENDS A MESSAGE TO THE TOPIC
  producer.send(new ProducerRecord[Int, String](topicName, 1,transaction))

  producer.send(new ProducerRecord[Int, String](topicName, 10, "Message 1"))
  producer.send(new ProducerRecord[Int, String](topicName, 20, "Message 2"))
  producer.send(new ProducerRecord[Int, String](topicName, 30, "Message 3"))
  producer.send(new ProducerRecord[Int, String](topicName, 40, "Message 4"))


  producer.flush()

}