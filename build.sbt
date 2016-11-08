name := "shaclexapi"

version := "1.0-SNAPSHOT"

lazy val pruebasPlay = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "es.weso" % "shaclex_2.11" % "0.0.52" excludeAll(ExclusionRule(organization = "org.slf4j"))
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test

resolvers += Resolver.bintrayRepo("labra", "maven")
