package org.wayneyu.otter.twitter.client

import twitter4j.{StallWarning, Status, StatusDeletionNotice, StatusListener}

/**
  * Created by wayneyu on 5/23/16.
  */
trait DefaultStatusListener extends StatusListener {
  def onStatus(status: Status) { printf("Tweet: %s, User: %s\n", status.getText, status.getUser.getLocation) }
  def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
  def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
  def onException(ex: Exception) { ex.printStackTrace() }
  def onScrubGeo(arg0: Long, arg1: Long) {}
  def onStallWarning(warning: StallWarning) {}
}

object DefaultStatusListener extends DefaultStatusListener {}