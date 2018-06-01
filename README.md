This directory contains a simple example on how to use  Yamcs as a XTCE TM Packet processor library.
The example consists of just one file with a main function:

https://github.com/yamcs/xtce-extractor/blob/master/src/main/java/org/yamcs/examples/XtceExtractor.java

To build, after cloning the repository just issue:
mvn package


To run:
java -jar target/xtce-extractor-1.0.jar


The XTCE database is configured in src/main/resources/mdb.yaml. Currently it points to an XML file in the mdb directory.

