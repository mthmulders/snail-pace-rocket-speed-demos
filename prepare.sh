#!/usr/bin/env bash
set -euo pipefail

# TODO Somehow ensure we're on Java 21

# Delete cache
if [ -e "$HOME/.m2/build-cache/v1/org.apache.shiro" ]; then
  rm -rf "$HOME/.m2/build-cache/v1/org.apache.shiro"*
fi

# Start the Docker container for visualising the build
./startJaeger.sh

# Fetch the Shiro repository
git submodule init
git submodule update --recursive

# Do a one-time build so that we have (most) dependencies and plugins downloaded
pushd shiro
mvn verify -pl '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'
popd
