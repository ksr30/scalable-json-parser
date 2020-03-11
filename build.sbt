name := "scalable-json-parser"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.1.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.13"

// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.2"

// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-scala
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.10.1"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.7"

// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.5"

libraryDependencies += "net.manub" %% "scalatest-embedded-kafka" % "2.0.0" % "test"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"








