import sbt.Keys.libraryDependencies

lazy val commonDep = Seq(

  //deduplicate with bdcsc2 on slf4j,so add provided
  libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.21" % "provided",
  libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.6.0" % "provided",

  //Spark
  libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.2" % "provided",
  libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.6.2" % "provided",
  libraryDependencies += "org.apache.spark" % "spark-hive_2.10" % "1.6.2" % "provided",
  libraryDependencies += "org.lz4" % "lz4-java" % "1.4.0",
  unmanagedJars in Compile += file("repository/betacatcommon.jar"),
  unmanagedJars in Compile += file("repository/spark.jar"),
  libraryDependencies += "com.databricks" % "spark-csv_2.10" % "1.4.0"
)

lazy val carModel = (project in file("src/test"))
  .settings(commonDep: _*)
  .settings(
    // unmanagedJars in Compile += file("repository/betacatcommon.jar"),
    scalaSource in Compile := baseDirectory.value,
    // Assembly sbt ";project carModel;clean;assembly"
    mainClass in assembly := Some("car.Process"),
    // mainClass in assembly := Some("task.DataFramTest"),
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/CARModel.jar"
  )

lazy val marchPhone = (project in file("src/marchphone"))
  .settings(commonDep: _*)
  .settings(
    // unmanagedJars in Compile += file("repository/betacatcommon.jar"),
    scalaSource in Compile := baseDirectory.value,
    // Assembly sbt ";project marchPhone;clean;assembly"
    mainClass in assembly := Some("car.Process"),
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.2"%"provided" ,
    // mainClass in assembly := Some("task.DataFramTest"),
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    //assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/MarchPhone.jar"
  )

lazy val sendMessage = (project in file("src/sendmessage"))
  .settings(commonDep: _*)
  .settings(
    scalaSource in Compile := baseDirectory.value,
    libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0",
    libraryDependencies += "log4j" % "log4j" % "1.2.14" % "provided",
    // Assembly sbt ";project sendMessage;clean;assembly"
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    //assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/sendMessage.jar"
  )

lazy val searchByd = (project in file("src/searchbyd"))
  .settings(commonDep: _*)
  .settings(
    scalaSource in Compile := baseDirectory.value,
    libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0",
    libraryDependencies += "log4j" % "log4j" % "1.2.14" ,
    libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.11" ,

  // Assembly sbt ";project sendMessage;clean;assembly"
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    //assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/searchByd.jar"
  )

lazy val CarClue = (project in file("src/carclue"))
  .settings(commonDep: _*)
  .settings(
    scalaSource in Compile := baseDirectory.value,
    libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0",
    libraryDependencies += "log4j" % "log4j" % "1.2.14" ,
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.2"% "provided" ,
    libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.11" ,

    // Assembly sbt ";project CarClue;clean;assembly"
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    //assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/CarClue.jar"
  )

lazy val HiveUDF = (project in file("src/hiveudf"))
  .settings(commonDep: _*)
  .settings(
    // unmanagedJars in Compile += file("repository/betacatcommon.jar"),
    scalaSource in Compile := baseDirectory.value,
    libraryDependencies +="junit" % "junit" % "4.11" ,
    libraryDependencies += "org.hamcrest" % "hamcrest-core" % "1.3" ,
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.2"% "provided" ,
    libraryDependencies += "log4j" % "log4j" % "1.2.14" ,
    // Assembly sbt ";project HiveUDF;clean;assembly"
    mainClass in assembly := Some("Process_Main"),
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/HiveUDF.jar"
  )

lazy val MRCompress = (project in file("src/mrcompress"))
  .settings(commonDep: _*)
  .settings(
    // unmanagedJars in Compile += file("repository/betacatcommon.jar"),
    scalaSource in Compile := baseDirectory.value,
    libraryDependencies +="junit" % "junit" % "4.11" ,
    libraryDependencies += "org.hamcrest" % "hamcrest-core" % "1.3" ,
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.2"% "provided" ,
    libraryDependencies += "log4j" % "log4j" % "1.2.14" ,
    // Assembly sbt ";project MRCompress;clean;assembly"
    mainClass in assembly := Some("Process_Main"),
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/MRCompress.jar"
  )

lazy val MRConf = (project in file("src/mrconf"))
  .settings(commonDep: _*)
  .settings(
    scalaSource in Compile := baseDirectory.value,
    libraryDependencies +="junit" % "junit" % "4.11" ,
    libraryDependencies += "org.hamcrest" % "hamcrest-core" % "1.3" ,
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.2"% "provided" ,
    libraryDependencies += "log4j" % "log4j" % "1.2.14" ,
    libraryDependencies += "org.apache.hive" % "hive-storage-api" % "2.1.0",
    libraryDependencies += "org.apache.orc" % "orc-core" % "1.1.0",
    libraryDependencies += "org.apache.orc" % "orc-mapreduce" % "1.1.0",
    // Assembly sbt ";project MRConf;clean;assembly"
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/MRConf.jar"
  )

lazy val Uxin = (project in file("src/uxin_mobile_user"))
  .settings(commonDep: _*)
  .settings(
    scalaSource in Compile := baseDirectory.value,
    libraryDependencies +="junit" % "junit" % "4.11" ,
    libraryDependencies += "org.hamcrest" % "hamcrest-core" % "1.3" ,
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.2"% "provided" ,
    libraryDependencies += "log4j" % "log4j" % "1.2.14" ,
    // Assembly sbt ";project Uxin;clean;assembly"
    resourceDirectory in Compile := baseDirectory.value / "resource",
    target in assembly := baseDirectory.value,
    //打包时，排除scala类库
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyJarName in assembly := s"../../model/Uxin.jar"
  )

lazy val Demo = (project in file("src/main"))
  .settings(commonDep: _*)
  .settings(
      scalaSource in Compile := baseDirectory.value,
      libraryDependencies +="junit" % "junit" % "4.11" ,
      libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.2"% "provided" ,
      libraryDependencies += "log4j" % "log4j" % "1.2.14" ,
      // Assembly sbt ";project Uxin;clean;assembly"
      resourceDirectory in Compile := baseDirectory.value / "resource",
      target in assembly := baseDirectory.value,
      //打包时，排除scala类库
      assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
      assemblyJarName in assembly := s"../../model/Demo.jar"
  )