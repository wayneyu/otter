package org.wayneyu.otter.kafka

import java.util.Properties

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

/**
  * Created by wayneyu on 5/24/16.
  */
class KafkaProducerSpec extends FlatSpec with Matchers with BeforeAndAfter{

  val defaultProps = new Properties()
  defaultProps.load(getClass.getClassLoader.getResourceAsStream("kafka.properties"))

  behavior of "Kafka producer"

  it should "use TwitterStream when no topic is supplied" in {
    val client = KafkaProducer(defaultProps)
    client.topic should be (defaultProps.getProperty("topic"))
  }

  it should "send message to TwitterTest topic" in {
    val client = KafkaProducer(defaultProps)
    client.send("test sending tweet").get()
  }

}
