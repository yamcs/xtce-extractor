This directory contains a simple example on how to use  Yamcs as a XTCE TM Packet processor.

To build, after cloning the repository just issue:
mvn package


To run:
java -jar target/xtce-extractor-1.0.jar


The XTCE database is configured in src/main/resources/mdb.yaml. Currently it points to an XML file in the mdb directory.

