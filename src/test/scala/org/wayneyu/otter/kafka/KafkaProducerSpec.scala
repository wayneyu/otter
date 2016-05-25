package org.wayneyu.otter.kafka

import java.util.Properties

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

/**
  * Created by wayneyu on 5/24/16.
  */
class KafkaProducerSpec extends FlatSpec with Matchers with BeforeAndAfter{

  val TEST_TOPIC = "TwitterTest"
  val defaultProps = new Properties()
  defaultProps.put("bootstrap.servers", "kafka0:9092")
  defaultProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  defaultProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  defaultProps.put("request.required.acks", "1")

  behavior of "Kafka producer"

  it should "use TwitterStream when no topic is supplied" in {
    val client = KafkaProducer(defaultProps)
    client.topic should be ("TwitterStream")
  }

  it should "send message to TwitterTest topic" in {
    val client = KafkaProducer(defaultProps, TEST_TOPIC)
    client.send("test sending tweet").get()
  }
}
