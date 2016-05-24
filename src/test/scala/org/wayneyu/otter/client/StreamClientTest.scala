package org.wayneyu.otter.client

import org.scalatest._

/**
  * Created by wayneyu on 5/23/16.
  */
object StreamClientTest extends FlatSpec with Matchers {

  "A stream client" should "return use correct config" in {
    val config = AppConfig.config
    val listener = new CustomStatusListener
    val streamer = new StreamClient(config, listener).stream
    streamer.getConfiguration should be (config)
  }
}
