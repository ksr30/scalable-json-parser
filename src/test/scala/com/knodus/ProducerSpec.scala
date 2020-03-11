package com.knodus


import net.manub.embeddedkafka.{EmbeddedKafka, EmbeddedKafkaConfig}
import org.scalatest.{BeforeAndAfterAll, FlatSpec}


class ProducerSpec extends FlatSpec with EmbeddedKafka with BeforeAndAfterAll {

  val topic = "test-topic"
  val producer:Producer = new Producer
 // implicit val config = EmbeddedKafkaConfig(kafkaPort = 12344, zooKeeperPort = 12345)


  override def beforeAll(): Unit = {
    EmbeddedKafka.start()
  }

  "Producer Function" should "publish synchronously data to kafka" in {
    producer.writeToKafka(topic)
    val response = consumeFirstStringMessageFrom(topic)
    assert(Some(response).isDefined)
  }

  override def afterAll(): Unit = {
    EmbeddedKafka.stop()
  }

}
