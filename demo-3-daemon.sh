#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd demo-resources/app-simple
# Maven Daemon and the OpenTelemetry extension don't work well together (yet)
# cp ../../demo-3-resources/extensions.xml .mvn/

echo Clean up earlier builds
read
mvnd3 clean --quiet

echo Perform a build using Maven Daemon
read
mvnd3 verify -Dsmartbuilder.profiling=true

popd
