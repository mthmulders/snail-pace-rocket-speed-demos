#!/usr/bin/env bash
set -euo pipefail

# TODO Somehow ensure we're on Java 21

# Pull the Docker container for visualising the build
docker pull jaegertracing/all-in-one:1.54

# Fetch the Shiro repository
git submodule init
git submodule update

# Do a one-time build so that we have (most) dependencies and plugins downloaded
pushd shiro
mvn verify -pl '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'
popd