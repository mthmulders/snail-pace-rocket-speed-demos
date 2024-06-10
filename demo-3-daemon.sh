#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

cp demo-3-resources/extensions.xml shiro/.mvn/

pushd shiro

echo 
echo Clean up earlier builds
echo 
read 
mvnd3 clean --projects :shiro-core --also-make

echo 
echo Perform a build using regular Maven 3
echo 
read 
mvn3 verify --projects :shiro-core --also-make -Dotel.traces.exporter=otlp

echo 
echo Clean up earlier builds
echo 
read 
mvnd3 clean --projects :shiro-core --also-make

echo 
echo Perform a build using Maven Daemon 3
echo 
read 
# otel doesnt work nicely with mvnd
# -Dotel.traces.exporter=otlp
export OTEL_METRICS_EXPORTER=none
mvnd3 verify --projects :shiro-core --also-make

