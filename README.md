This directory contains a simple example on how to use  Yamcs as a XTCE TM Packet processor.

To build, after cloning the repository just issue:
mvn package


To run:
java -jar target/xtce-extractor-1.0.jar



The XTCE database is configured in src/main/resources/mdb.yaml. Currently it points to an XML file in the mdb directory.

### Note
As of 12-March-2016, this example only works with the 0.29.4-SNAPSHOT version of Yamcs. In order to be able to download snapshot releases from the maven repository, please add the following in the ~/.m2/settings.xml:
```xml
<settings>
  <profiles>
    <profile>
      <id>allow-snapshots</id>
        <activation><activeByDefault>true</activeByDefault></activation>
      <repositories>
        <repository>
          <id>snapshots-repo</id>
          <url>https://oss.sonatype.org/content/repositories/snapshots</url>
          <releases><enabled>false</enabled></releases>
          <snapshots><enabled>true</enabled></snapshots>
         </repository>
       </repositories>
     </profile>
  </profiles>
</settings>
```
