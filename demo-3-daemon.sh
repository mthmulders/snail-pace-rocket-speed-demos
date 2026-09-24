#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euo pipefail

pushd demo-resources/app-simple
# Maven Daemon and the OpenTelemetry extension don't work well together (yet)
# cp ../../demo-3-resources/extensions.xml .mvn/

echo Clean up earlier builds
mvnd3 clean --quiet
clear

echo Inspect status of Maven daemon
echo "$ mvnd --status"
mvnd3 --status

echo Perform a build using Maven Daemon
echo "$ mvnd verify -Dsmartbuilder.profiling=true"
read
# --activate-profiles parallel-tests
mvnd3 verify -Dsmartbuilder.profiling=true

popd
