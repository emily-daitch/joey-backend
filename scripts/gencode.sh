#!/bin/bash

mvn clean package -Dmaven.test.skip;
java -jar target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar db migrate local.yml;
pg_dump -h 172.24.160.1 -p 5432 -U joeydbtestuser -W -d joeydb --schema-only > src/test/resources/sql/create_schema.sql;
zip -vr "src/main/resources/generated_backups/generated_bak_$timestamp.zip" src/main/java/ccw/generated;
java -jar target/malamut-1.0-SNAPSHOT.jar codegen local.yml --dry-run false;
java -Ddw.server.applicationConnectors[0].port=9090 -jar  target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar server local.yml &
sleep 3;
~/joey/material-kit-react/scripts/sync.sh &&
kill %1