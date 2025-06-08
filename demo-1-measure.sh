#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

echo Navigate to http://localhost:16686/
read

pushd demo-resources/app-simple
cp ../../demo-1-resources/extensions.xml .mvn/
read

mvn3 --file pom.xml -Dotel.traces.exporter=otlp verify
rm .mvn/extensions.xml

popd
