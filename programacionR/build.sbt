ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "programacionR",

    libraryDependencies += "io.monix" %% "monix" % "3.4.0",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.9.0-M2"
  )
