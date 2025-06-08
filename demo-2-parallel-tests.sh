#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd demo-resources/app-simple
cp ../../demo-2-resources/extensions.xml .mvn/
mvn3 clean --quiet
read

mvn3 verify -Dotel.traces.exporter=otlp --activate-profiles parallel-tests
rm .mvn/extensions.xml

popd
