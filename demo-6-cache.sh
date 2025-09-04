#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd demo-resources/app-simple
cp ../../demo-6-resources/extensions.xml .mvn/

echo Clean up earlier build caches
rm -Rf ~/.m2/build-cache/

echo First run, populates cache
read
mvn3 --file pom.xml verify -Dotel.traces.exporter=otlp

echo Second run, leverages cache
read

mvn3 --file pom.xml verify -Dotel.traces.exporter=otlp

echo Edit a constant file in the JAX-RS configuration
perl -i.bak -pe 's,"api","api/v1",g' web/rest/src/main/java/de/bmarwell/snailspace/demo4/app/web/rest/WebApplication.java
read

mvn3 --file pom.xml verify -Dotel.traces.exporter=otlp

git restore web/rest/src/main/java/de/bmarwell/snailspace/demo4/app/web/rest/WebApplication.java
git restore .mvn/extensions.xml

popd
