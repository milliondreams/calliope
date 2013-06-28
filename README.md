Calliope
========
Calliope is a library providing an interface to consume data from Cassandra to spark and store RDDs from Spark to Cassandra.

In Greek mythology, Calliope (/kəˈlaɪ.əpiː/ kə-ly-ə-pee; Ancient Greek: Καλλιόπη Kalliopē "beautiful-voiced") was the muse of epic poetry,daughter of Zeus and Mnemosyne, and is believed to be Homer's muse, the inspiration for the Odyssey and the Iliad.

We hope Calliope will also be the muse for your epic data poetry!

For more information visit - http://tuplejump.github.com/calliope

## Download Binary

You can download the library from [here](https://oss.sonatype.org/service/local/repositories/releases/content/com/tuplejump/calliope_2.9.3/0.7.3/calliope_2.9.3-0.7.3.jar)

## Add to Maven

```xml
<dependency>
  <groupId>com.tuplejump</groupId>
  <artifactId>calliope_2.9.3</artifactId>
  <version>0.7.3</version>
</dependency>
```

## Add to SBT
```scala
libraryDependencies += "com.tuplejump" %% "calliope" % "0.7.3"
```

**Note on Scala version**
Calliope is buil with Scala 2.9.3, the same version as the current release of Spark. In future when Spark moves on to newer Scala version, we will try to keep releasing Calliope with all the versions of Scala for which Spark is available.

