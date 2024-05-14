#!/usr/bin/env bash
set -euo pipefail

# TODO Somehow ensure we're on Java 21

# Delete cache
if [ -e "$HOME/.m2/build-cache/v1/org.apache.shiro" ]; then
  rm -rf "$HOME/.m2/build-cache/v1/org.apache.shiro"*
fi

# Start the Docker container for visualising the build
docker run --rm --name jaeger \
  -e COLLECTOR_ZIPKIN_HOST_PORT=:9411 \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 4317:4317 \
  -p 4318:4318 \
  -p 14250:14250 \
  -p 14268:14268 \
  -p 14269:14269 \
  -p 9411:9411 \
  -d \
  docker.io/jaegertracing/all-in-one:1.57

# Fetch the Shiro repository
git submodule init
git submodule update --recursive

# Do a one-time build so that we have (most) dependencies and plugins downloaded
pushd shiro
mvn verify -pl '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'
popd
