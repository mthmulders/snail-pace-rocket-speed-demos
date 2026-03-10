#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd demo-resources/app-simple

echo Clean up earlier builds
read
mvn3 clean --quiet

echo
echo
echo "now running mvn verify with parallel tests enabled"
echo
echo "mvn verify --activate-profiles parallel-tests"
echo

read

mvn3 verify -Dotel.traces.exporter=otlp --activate-profiles parallel-tests

popd
