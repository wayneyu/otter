package org.wayneyu.otter.kafka

import java.util.Properties

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by wayneyu on 5/24/16.
  */
class KafkaProducerTest extends FlatSpec with Matchers {
  val defaultProps = new Properties()
  defaultProps.put("bootstrap.servers", "localhost:9092")
  defaultProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  defaultProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  "Kafka client" should "use TwitterTest when no topic is supplied" in {
    val client = KafkaProducer(defaultProps)
    client.topic should be ("TwitterTest")
  }
}
