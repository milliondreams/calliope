---
layout: default
title: Troubleshooting - Calliope
---

# 911, What's your emergency?

If you are facing ANY issue or need any help using calliope, please file in an issue or contact opensource *at* tuplejump *dot* com.


####Why do I get a "No Implicit View Defined for X => Y" message while compiling?

Calliope relies on Implicits to convert to and from ByteBuffer and structures around it to Usable data types. In case you have a key or value type that doesn't have a implicit convertor defined, you will have to write one of your own. Don't worry this is easy, just look at the test cases.

####Why do I get a ByteBuffer not Serializable error while the computing on RDD created from Cassandra?

You **should** give Type Parameters to sc.cassandra method and provide appropriate transformers for that.

