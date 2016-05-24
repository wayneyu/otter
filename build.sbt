name := """twmapper"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "4.0.4"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.10.0.0"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

