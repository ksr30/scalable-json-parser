package com.knodus

import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._


class Consumer {

  def consumeFromKafka(topic: String) = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "com.knodus.UserDeserializer")
    props.put("auto.offset.reset", "latest")
    props.put("group.id", "consumer-group")
    val consumer: KafkaConsumer[String, User] = new KafkaConsumer[String, User](props)
    consumer.subscribe(util.Arrays.asList(topic))

    val record = consumer.poll(1000).asScala
    for (data <- record.iterator) {
      println(data.value())
    }

  }

}

object Consumer extends App {
  val c: Consumer = new Consumer
  c.consumeFromKafka("quick-start")

}
