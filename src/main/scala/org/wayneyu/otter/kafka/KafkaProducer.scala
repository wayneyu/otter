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
  val defaultProps = new Properties()
  defaultProps.load(getClass.getClassLoader.getResourceAsStream("kafka.properties"))
  val defaultTopic = defaultProps.getProperty("topic")

  def apply(props: Properties, topic: String) : KafkaProducer = new KafkaProducer(props, topic)
  def apply(props: Properties) : KafkaProducer = this(props, defaultTopic)
  def apply() : KafkaProducer = this(defaultProps, defaultTopic)
}