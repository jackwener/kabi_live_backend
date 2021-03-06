lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-starter-example""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.4",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ),
    libraryDependencies ++= Seq(
      "com.pauldijou" %% "jwt-play" % "0.19.0",
      "com.pauldijou" %% "jwt-core" % "0.19.0",
      "com.auth0" % "jwks-rsa" % "0.6.1"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
