ThisBuild / scalaVersion := "3.1.0"


lazy val jsdocs = project
  .settings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.0.0"
  )
  .enablePlugins(ScalaJSPlugin)

lazy val docs = project
  .in(file("myproject-docs"))
  .settings(
    mdocIn := (ThisBuild / baseDirectory).value / "docs",
    mdocOut := target.value / "mdoc",
    Compile / doc / scalacOptions ++= Seq("-siteroot", mdocOut.value.toString),
    Compile / doc / target := (ThisBuild / baseDirectory).value / "website",
    mdocJS := Some(jsdocs),
  )
  .enablePlugins(MdocPlugin)
