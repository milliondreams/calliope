---
layout: default
title: The code - Calliope
---

# Enough, talk, show me the Code

Here you go!

## CQL3
This method uses the brand new CqlPagingInputFormat and CqlPagingOutputFormat. This is a fresh out of the mint interface and may have bugs/issues, but the good part is it can read any Column Fmailies, event the ones created with CQL3 and using Composite keys.

### Reading from Cassandra 

To read a **Column Family** names *Words* from a **keyspace** *casDemo* and create an RDD from it, here is the code required using Calliope, considering the **keys** are *Strings* and the so are rest of the columns.

```scala
import com.tuplejump.calliope.utils.RichByteBuffer._
import com.tuplejump.calliope.Implicits._
import com.tuplejump.calliope.CasBuilder

val cas = CasBuilder.cql3.with("casDemo", "Words")
val rdd = sc.cql3Cassandra[Map[String, String], Map[String, String](cas)

```

or since we don't need to customize any of the advanced Cassandra connection options, you can use the simplified API,
```scala
val rdd = sc.cql3Cassandra[Map[String, String], Map[String, String]("Words", "casDemo")
```
or when Cassandra is not on the same host as the SparkContext,

```scala
val rdd = sc.cql3Cassandra[Map[String, String], Map[String, String]("casserver.local", "9160", Words", "casDemo")
```

And now you have a RDD! Further you can also use a where predicate in line with the CQL3 where predicates, i.e. should atleast have 1 EqualTo condition and can be only on columns with secodary indexes.

```scala
val cas = CasBuilder.cql3.with("casDemo", "Words").where("book = 'The Three Musketeers'")
val rdd = sc.cql3Cassandra[Map[String, String], Map[String, String](cas)
```
This will use the Cassandra secondary index to filter out the data and will give you faster results...


### Writing to Cassandra
To write an RDD[Map[String, String], Map[String, String]], which is a Map of PrimaryKeys -> Values and RemaingColumns -> Values, to a **Column Family** names *Words* from a **keyspace** *casDemo*

```scala
import com.tuplejump.calliope.utils.RichByteBuffer._
import com.tuplejump.calliope.Implicits._
import com.tuplejump.calliope.CasBuilder

val cas = CasBuilder.cql3.with("casDemo", "Words").("UPDATE casDemo.words set book_name = ?, book_content = ?")
rdd.cql3SaveToCassandra(cas)
```

This will use the Keys from the first map in the RDD to write the alues from the second. It only allows Update query, if the keys don't already exist a new row will be created, if it does it will be updated. If the row exists and a column value is not provided, that colmun will be deleted.

## Thrift 
In this method internally we use ColumnFamilyInputFormat and ColumnFamilyOutputFormat. This method is older and more tested, but will not be able to read from CQL3 Column Families with composite keys.

### Reading from Cassandra 

To read a **Column Family** names *Words* from a **keyspace** *casDemo* and create an RDD from it, here is the code required using Calliope, considering the **key** is a *String* and the **row** has all column names and values as *String*.

```scala
import com.tuplejump.calliope.utils.RichByteBuffer._
import com.tuplejump.calliope.Implicits._
import com.tuplejump.calliope.CasBuilder

val cas = CasBuilder.thrift.with("casDemo", "Words")
val rdd = sc.thriftCassandra[String, Map[String, String](cas)

```

or since we don't need to customize any of the advanced Cassandra connection options, you can use the simplified API,
```scala
val rdd = sc.thriftCassandra[String, Map[String, String]("Words", "casDemo")
```
or when Cassandra is not on the same host as the SparkContext,

```scala
val rdd = sc.thriftCassandra[String, Map[String, String]("casserver.local", "9160", Words", "casDemo")
```

And now you have a RDD[String, Map[String, String]]!

To fully appreciate the ease and terseness of the above code, I recomend you take a look at the the Cassandra example in Spark examples code.



### Writing to Cassandra
To write an RDD[String, Map[String, String]] a **Column Family** names *Words* from a **keyspace** *casDemo* 

```scala
import com.tuplejump.calliope.RichByteBuffer._
import com.tuplejump.calliope.Implicits._
import com.tuplejump.calliope.CasBuilder

val cas = CasBuilder.thrift.with("casDemo", "Words")
rdd.thriftSaveToCassandra(cas)
```

Check out the Test Specs for more details . . .
