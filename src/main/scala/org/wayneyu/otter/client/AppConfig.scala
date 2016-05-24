package org.wayneyu.otter.client

/**
  * Created by wayneyu on 5/24/16.
  */

object AppConfig {
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
