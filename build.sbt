name := "play-morphia"
organization := "it.unifi.cerm"

description := "Play 2.8.x Module for Morphia http://mongodb.github.io/morphia/"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  guice,
  "dev.morphia.morphia" % "morphia-core" % "2.2.7",
  "org.easytesting" % "fest-assert" % "1.4" % "test"
) 
