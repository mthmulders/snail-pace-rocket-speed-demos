#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

echo Navigate to http://localhost:16686/
read

cp demo-1-resources/extensions.xml shiro/.mvn/

pushd shiro

mvn3 --file pom.xml -Dotel.traces.exporter=otlp verify --projects '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'

rm .mvn/extensions.xml

popd