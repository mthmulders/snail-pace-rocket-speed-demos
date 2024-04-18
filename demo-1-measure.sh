#!/usr/bin/env bash
set -euox pipefail

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
  jaegertracing/all-in-one:1.54

echo Navigate to http://localhost:16686/
read

pushd shiro

cp ../extensions.xml ./.mvn/

mvn3 --file pom.xml -Dotel.traces.exporter=otlp verify --projects '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'

rm .mvn/extensions.xml

popd