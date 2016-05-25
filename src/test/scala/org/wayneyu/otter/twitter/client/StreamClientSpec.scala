package org.wayneyu.otter.twitter.client

import org.scalatest._

/**
  * Created by wayneyu on 5/23/16.
  */
class StreamClientSpec extends FlatSpec with Matchers {

  behavior of "Stream client"

  it should "use config passed in to the constructor" in {
    val config = AppConfig.config
    val listener = new CustomStatusListener
    val streamer = new StreamClient(config, listener).stream
    streamer.getConfiguration should be (config)
  }
}
