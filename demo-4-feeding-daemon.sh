#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd demo-6-resources/app-more-modules
# Maven Daemon and the OpenTelemetry extension don't work well together (yet)
# cp ../../demo-3-resources/extensions.xml .mvn/

echo Clean up earlier builds
read
mvn3 clean --quiet

echo Perform a build using Maven Daemon
read 
mvnd3 verify

popd
