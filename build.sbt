
ThisBuild / scalaVersion := "3.1.0"

Compile / doc / target := file("website")
Compile / doc / scalacOptions ++= Seq("-siteroot", "docs")

