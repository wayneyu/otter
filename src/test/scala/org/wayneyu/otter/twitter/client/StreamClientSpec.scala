package org.wayneyu.otter.twitter.client

import java.util.Properties

import org.scalatest.{FlatSpec, Matchers}
import twitter4j.Status

/**
  * Created by wayneyu on 5/23/16.
  */
class StreamClientSpec extends FlatSpec with Matchers {

  val props = new Properties()
  props.load(getClass.getClassLoader.getResourceAsStream("prod.env"))

  val defaultConfig = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey(props.getProperty("TWITTER_CONSUMER_KEY"))
    .setOAuthConsumerSecret(props.getProperty("TWITTER_CONSUMER_SECRET"))
    .setOAuthAccessToken(props.getProperty("TWITTER_ACCESS_TOKEN"))
    .setOAuthAccessTokenSecret(props.getProperty("TWITTER_ACCESS_TOKEN_SECRET"))
    .build

  behavior of "Stream client"

  it should "use config passed in to the constructor" in {
    val config = AppConfig.config
    val listener = DefaultStatusListener
    val stream = StreamClient(config, listener).stream
    stream.getConfiguration should be (config)
  }

  it should "use default config when config is not passed" in {
    val stream = StreamClient(DefaultStatusListener).stream
    stream.getConfiguration should be (defaultConfig)
  }

  it should "connect to twitter stream api and call sample api" in {
    val listener = CollectStatusListener
    val stream = StreamClient(listener).stream
    stream.sample("en")
    Thread.sleep(3000)
    stream.cleanUp()
    stream.shutdown()

    listener.statuses.size should be > 0
  }

  object CollectStatusListener extends DefaultStatusListener {
    var statuses = List[String]()
    override def onStatus(status: Status) = { statuses ::= status.getText}
  }
}
