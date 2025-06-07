#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

cp demo-3-resources/extensions.xml shiro/.mvn/

pushd shiro

echo 
echo Clean up earlier builds
echo 
read var
mvnd3 clean --projects :shiro-core --also-make



echo 
echo Perform a build using Maven Daemon 3
echo 
read var
# otel doesnt work nicely with mvnd
# -Dotel.traces.exporter=otlp
export OTEL_METRICS_EXPORTER=none
mvnd3 verify --projects :shiro-core --also-make
