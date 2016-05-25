package org.wayneyu.otter.twitter.producer

import org.wayneyu.otter.kafka.KafkaProducer
import org.wayneyu.otter.twitter.client.{DefaultStatusListener, StreamClient}
import twitter4j.{FilterQuery, Status}

/**
  * Created by wayneyu on 5/24/16.
  */
class RandomStatusProducer(val durationMs: Long) extends StreamProducer with DefaultStatusListener {

  val stream = StreamClient(this).stream
  val kafkaProducer = KafkaProducer()

  override def onStatus(status: Status) = kafkaProducer.send(status.getText)

  def produce()  = {
    // 1. connect to client
    // 2. make api call
    // 3. publish response to kafka on listener event
    stream.sample("en")
    Thread.sleep(durationMs)
    stream.cleanUp()
    stream.shutdown()
  }

}

object RandomStatusProducer {
  val DEFAULT_DURATION_MS = 10000
  def apply(durationMs: Long): RandomStatusProducer = new RandomStatusProducer(durationMs)
  def apply(): RandomStatusProducer = this(DEFAULT_DURATION_MS)
}
