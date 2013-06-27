---
layout: default
title: CasBuilder - Calliope
---
# Bricks and Mortar
Cassandra configuration has a lot of options. not all of which are relevant in all scenarios. CasBuilder provides you with ability to set only the necessary options (keyspace and columnfamily) to start using calliope. You can still change other settings if required.

## Cql3 or Thrift

The first choice you will make with CasBuilder is whether you want to use Cql3 or Thrift. Both these methods take no parameter and return respective builders. 

```scala
val cqlBuilder = CasBuilder.cql3
```
or

```scala
val thriftBuilder = CasBuilder.thrift
```

## Keyspace and Column Family

CasBuilder forces you to provide the two compulsory configuration settings, namely keyspace and columnfamily.

```scala
CasBuilder.cql3.withColumnFamile(keyspace, columnFamily)
```
or

```scala
CasBuilder.thrift.withColumnFamile(keyspace, columnFamily)
```

## And the rest

### Cql3 Builder

* onHost(h :String)
* onPort(p: Port)
* partitionUsing(p:CasPartitioner.Value)
* columns(String*) or columns(List[String])
* authAs(user:String)
* withPassword(pass: String)
* setPageSize(size:Long)
* where(clause:String)
* saveWithQuery(query:String)

### Thrift Builder

* onHost(h :String)
* onPort(p: Port)
* partitionUsing(p:CasPartitioner.Value)
* columns(String*) or columns(List[String])
* forWideRows(hwr: Boolean)
* columnsInRange(start: Array[Byte], finish: Array[Byte])
* authAs(user:String)
* withPassword(pass: String)
* where(q:FinalQuery)
