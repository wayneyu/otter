package org.wayneyu.otter.twitter.client

import java.util.Properties

/**
  * Created by wayneyu on 5/24/16.
  */

object AppConfig {

  val props = new Properties()
  props.load(getClass.getClassLoader.getResourceAsStream("prod.env"))

  val CONSUMER_KEY = props.getProperty("TWITTER_CONSUMER_KEY")
  val CONSUMER_KEY_SECRET = props.getProperty("TWITTER_CONSUMER_SECRET")
  val ACCESS_TOKEN = props.getProperty("TWITTER_ACCESS_TOKEN")
  val ACCESS_TOKEN_SECRET = props.getProperty("TWITTER_ACCESS_TOKEN_SECRET")

  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey(CONSUMER_KEY)
    .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
    .setOAuthAccessToken(ACCESS_TOKEN)
    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET)
    .build
}
