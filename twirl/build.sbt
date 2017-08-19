scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0"
)

lazy val root = (project in file(".")).
  enablePlugins(SbtTwirl)
