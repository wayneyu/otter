name := """otter"""

version := "1.0"

scalaVersion := "2.10.6"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "4.0.4" % "provided"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.9.0.1" % "provided"

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.1" % "provided"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.6.1" % "provided"

libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.10" % "1.6.1"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

test in assembly := {}

mergeStrategy in assembly := {
  case PathList("org", "apache", "spark", "unused", "UnusedStubClass.class") => MergeStrategy.first
  case x => (mergeStrategy in assembly).value(x)
}