package org.wayneyu.otter.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.ProducerRecord

/**
  * Created by wayneyu on 5/24/16.
  */
class KafkaProducer(val props: Properties, val topic: String) {

  val producer = new org.apache.kafka.clients.producer.KafkaProducer[String, String](props)

  def send(message: String) = {
    val record = new ProducerRecord[String, String](topic, message)
    producer.send(record)
  }

}

object KafkaProducer {
  val defaultTopic = "TwitterStream"
  val defaultProps = new Properties()
  defaultProps.put("bootstrap.servers", "kafka0:9092,kafka1:9092")
  defaultProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  defaultProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  def apply(props: Properties, topic: String) = new KafkaProducer(props, topic)
  def apply(props: Properties) = new KafkaProducer(props, defaultTopic)
  def apply() = new KafkaProducer(defaultProps, defaultTopic)
}