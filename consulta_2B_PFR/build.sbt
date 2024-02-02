ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "aaa",
    // https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.9.0-M2",
    // https://mvnrepository.com/artifact/com.typesafe.akka/akka-stream
    libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.9.0-M2"


  )
