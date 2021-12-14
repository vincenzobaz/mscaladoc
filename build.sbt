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
    mdocVariables := Map(
      "js-out-prefix" -> (mdocOut.value / "resources").getAbsolutePath
    ),
    Compile / scalaSource := (ThisBuild / baseDirectory).value / "src",
    Compile / doc / scalacOptions ++= Seq("-siteroot", mdocOut.value.toString),
    Compile / doc / target := (ThisBuild / baseDirectory).value / "website",
    mdocJS := Some(jsdocs),
  )
  .enablePlugins(MdocPlugin)
