#!/usr/bin/env bash
set -euo pipefail

# Start the Docker container for visualising the build
echo "Starting Jaeger image"
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
  docker.io/jaegertracing/all-in-one:1.57@sha256:8f165334f418ca53691ce358c19b4244226ed35c5d18408c5acf305af2065fb9
