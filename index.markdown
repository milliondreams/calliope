---
layout: default
title: Calliope, by tuplejump
---

#Why Cassandra + Spark?
Cassandra + Spark is the match made in heaven! Spark with it's in memory mapreduce allows us to process data upto 10x faster than Hadoop MapReduce, opening doors to iterative map reduce, complex process chains in a plain and simple start and so much more. Spark did away with the complex setup and configuration required by Hadoop M/R in it's early days. Overall, it make big data crunching fun!

The only bottleneck now is the HDFS or worse HBASE, which are still used by many Spark developers to build the applications and providing a distributed data store to the RDDs. Setting up and maintaining HDFS and maintianing the cluster, requires effort and experience. All HDFS provides is a filesystem. Anything you put there is a file and will be read line by line. This may work for unstructured data, but not so much wth strutured one. The problem with both these solutions is htey are Hadoop! There I said it!!!

Come in Cassandra, built on Dynamo's gossip with BigTable's column oriented storage, Cassandra provides a resilient fualt tollerant robust very high speed data store. Coming from the NoSQL family of databses, it provides flexible schema support, which makes it good for structured as well as unstructured data. Setting up and managing Cassandra cluster's is quick and easy.

Cassandra storage bckend with Spark will open many new avenues.

#Why Calliope?
Spark supports any Hadoop Input/Output provider and we know there is a Hadoop I/O for Cassandra, so I can simply use it! 
Yes, sure you can, and for now Calliope uses the same. But contrary to the Hadoop I/O API which was designed for java and Hadoop way of doing things, Calliope provides a improved cleaner API to create and persist RDDs, without exposing you to the internals. In furutre we would like to move away from Hadoop I/O here and build our own fat-free alternative. But, don't worry, we won't change the API for that.


