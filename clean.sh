#!/usr/bin/env bash
set -uo pipefail
# no set -x; if a file or container isn't there, it's OK

rm shiro/.mvn/extensions.xml
rm shiro/crypto/core/src/test/groovy/org/apache/shiro/crypto/FailingTest.java

find shiro/ -name "junit-platform.properties" -exec rm '{}' +

(cd shiro && git clean -fxd && git reset --hard HEAD)

rm -Rf ~/.m2/build-cache/v1/org.apache.shiro*
rm -Rf ~/.m2/build-cache/v1.1/org.apache.shiro*
