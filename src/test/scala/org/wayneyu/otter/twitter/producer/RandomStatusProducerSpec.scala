package org.wayneyu.otter.twitter.producer

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by wayneyu on 5/24/16.
  */
class RandomStatusProducerSpec extends FlatSpec with Matchers{
  behavior of "Random status stream producer"

  it should "connect to a twitter stream" in {
    val producer = RandomStatusProducer(5000)
    producer.produce()
  }
}
