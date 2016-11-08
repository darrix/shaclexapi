name := "shaclexapi"

version := "0.1"

lazy val shaclexVersion = "0.0.53"

lazy val shaclexapi = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

resolvers += Resolver.bintrayRepo("labra", "maven")

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "es.weso" % "shaclex_2.11" % "0.0.53" excludeAll(ExclusionRule(organization = "org.slf4j"))
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test

