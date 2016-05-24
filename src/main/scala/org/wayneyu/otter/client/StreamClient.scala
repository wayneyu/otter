package org.wayneyu.otter.client

import twitter4j.{StatusListener, TwitterStreamFactory}

/**
  * Created by wayneyu on 5/23/16.
  */
object StreamClient {
  def main(args: Array[String]) {
    val twitterStream = new TwitterStreamFactory(TwitterConfig.config).getInstance
    twitterStream.addListener(StreamListener.listener)
    twitterStream.sample()
    Thread.sleep(10000)
    twitterStream.cleanUp()
    twitterStream.shutdown()
  }
}

object TwitterConfig {
  val CONSUMER_KEY = System.getenv("TWITTER_CONSUMER_KEY")
  val CONSUMER_KEY_SECRET = System.getenv("TWITTER_CONSUMER_SECRET")
  val ACCESS_TOKEN = System.getenv("TWITTER_ACCESS_TOKEN")
  val ACCESS_TOKEN_SECRET = System.getenv("TWITTER_ACCESS_TOKEN_SECRET")

  val config = new twitter4j.conf.ConfigurationBuilder()
      .setOAuthConsumerKey(CONSUMER_KEY)
      .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
      .setOAuthAccessToken(ACCESS_TOKEN)
      .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET)
      .build
}