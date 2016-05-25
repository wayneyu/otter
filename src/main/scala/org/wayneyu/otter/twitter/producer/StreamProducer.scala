package org.wayneyu.otter.twitter.producer

/**
  * Created by wayneyu on 5/24/16.
  */
trait StreamProducer {
  def produce() : Unit
}
