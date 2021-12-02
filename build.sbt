ThisBuild / scalaVersion := "3.1.0"

Compile / doc / scalacOptions ++= Seq("-d", "website", "-siteroot", (baseDirectory.value / "docs").toString)

