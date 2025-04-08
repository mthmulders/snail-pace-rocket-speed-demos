#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd demo-resources/app-simple

echo 
echo "Clean up earlier builds (app with 3 modules)"
echo 
read 
mvnd3 clean

echo 
echo "Perform a build using Maven Daemon 3 (app with 3 modules)"
echo 
read 
# otel doesnt work nicely with mvnd
# -Dotel.traces.exporter=otlp
export OTEL_METRICS_EXPORTER=none
mvnd3 verify

popd

pushd demo-resources/app-more-modules

echo 
echo "Clean up earlier builds (app with 16+ modules)"
echo 
read 
mvnd3 clean

echo 
echo "Perform a build using Maven Daemon 3 (app with 16+ modules)"
echo 
read 
# otel doesnt work nicely with mvnd
# -Dotel.traces.exporter=otlp
export OTEL_METRICS_EXPORTER=none
mvnd3 verify
