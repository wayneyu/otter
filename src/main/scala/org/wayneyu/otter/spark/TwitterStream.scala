package org.wayneyu.otter.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming._
import org.wayneyu.otter.twitter.client.TwitterAppConfig
import twitter4j.auth.OAuthAuthorization

/**
  * Created by wayneyu on 6/9/16.
  */
object TwitterStream {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("otter").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val ssc = new StreamingContext(sc, Seconds(1))
    val oauth = new OAuthAuthorization(TwitterAppConfig.config)
    val stream = TwitterUtils.createStream(ssc, Option(oauth))

    stream.filter(_.getLang == "en").map(_.getText).flatMap(_.split(" ")).map(w => (w, 1)).reduceByKey(_ + _).print()

    ssc.start()
    ssc.awaitTerminationOrTimeout(30000)
  }
}
