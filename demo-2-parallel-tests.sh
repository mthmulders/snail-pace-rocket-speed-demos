#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd demo-resources/app-simple
mvn3 clean --quiet
read

mvn3 verify -Dotel.traces.exporter=otlp --activate-profiles parallel-tests

popd
