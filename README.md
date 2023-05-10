# Build with
mvn clean package
skipping tests: mvn clean package -Dmaven.test.skip

# Run with
java -Ddw.server.applicationConnectors[0].port=9090 -jar  target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar server local.yml
(building from above does create a package without dependencies too, which will not run... more on this later)