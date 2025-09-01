#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd demo-resources/app-simple

echo Clean up earlier builds
read
mvn3 --file pom.xml clean --quiet

echo Navigate to http://localhost:16686/
read

mvn3 --file pom.xml -Dotel.traces.exporter=otlp verify

popd
