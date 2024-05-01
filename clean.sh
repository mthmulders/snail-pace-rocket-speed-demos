#!/usr/bin/env bash
set -uo pipefail
# no set -x; if a file or container isn't there, it's OK

rm shiro/.mvn/extensions.xml
rm shiro/crypto/core/src/test/groovy/org/apache/shiro/crypto/FailingTest.java

docker stop jaeger