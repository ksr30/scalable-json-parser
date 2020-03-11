package com.knodus

import java.io.{File, PrintWriter}
import java.util.Properties

import com.google.gson.Gson
import org.apache.kafka.clients.producer._


class Producer {


  def writeToKafka(topic: String): Unit = {
    val props = new Properties()
    val file_Object = new File("/home/knoldus/Documents/Running/scalable-json-parser/src/main/resources/kafkaLogs.txt")
    val print_Writer = new PrintWriter(file_Object)
    val userDeatilsJson: String =
      """ {
        |	"id": "1",
        |	"name": "Krishna Singh",
        |	"age": "22",
        |	"address": "Delhi"
        |}""".stripMargin

    val gson: Gson = new Gson()
    val userDetail: User = gson.fromJson(userDeatilsJson, classOf[User])
    print_Writer.write(userDetail.toString)
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "com.knodus.UserSerializer")
    val producer = new KafkaProducer[String, User](props)
    val record = new ProducerRecord[String, User](topic, "key", userDetail)
    producer.send(record)
    producer.close()
    print_Writer.close()
  }
}

object Producer extends App {
  val p: Producer = new Producer
  p.writeToKafka("quick-start")
}

