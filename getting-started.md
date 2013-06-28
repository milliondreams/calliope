---
layout: default
title: Getting Started - Calliope
---

# Lights, Camera, Action!

This assumes you have a working Spark and Cassandra setup. Ideally you would install your cluster such that the spark workers run on the same servers as the cassandra nodes, to ensure best data locality and reduce network traffic.

## Using it with spark-shell

Download the released jar and add it to your Spark shell classpath and the workers using sc.addJar, or if you build Spark from trunk or using a version newer than Spark 0.7.2 you can use the ADD_JARS environment variable to do this.

Then you should import Implicits._, RichByteBuffer._ and CasBuilder to start using Calliope.

```scala
import com.tuplejump.calliope.Implicits._
import com.tuplejump.calliope.utils.RichByteBuffer._
import com.tuplejump.calliope.CasBuilder
```

## Using it in your project

Add Calliope Jar as dependency to your project build file.

