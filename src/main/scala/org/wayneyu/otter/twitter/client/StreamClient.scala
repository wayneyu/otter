package org.wayneyu.otter.twitter.client

import twitter4j.conf.Configuration
import twitter4j.{FilterQuery, TwitterStreamFactory, StatusListener}

/**
  * Created by wayneyu on 5/23/16.
  */
class StreamClient(config: Configuration, statusListener: StatusListener) {

  val twitterStream = new TwitterStreamFactory(config).getInstance
  twitterStream.addListener(statusListener)

  def stream = twitterStream
}

object StreamClient {
  def apply(config: Configuration, statusListener: StatusListener) = new StreamClient(config, statusListener)
  def apply(statusListener: StatusListener) : StreamClient = this(TwitterAppConfig.config, statusListener)
  def apply() : StreamClient = this(TwitterAppConfig.config, DefaultStatusListener)

  def main(args: Array[String]) {
    val stream = StreamClient().stream
    stream.filter(new FilterQuery().language("en").track(args(0)))
    Thread.sleep(10000)
    stream.cleanUp()
    stream.shutdown()
  }
}