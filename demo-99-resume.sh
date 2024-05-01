#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

# Shiro Crypto Core is one of the first modules in the build and depends on Shiro Lang.
cp  ./demo-99-resources/FailingTest.java ./shiro/crypto/core/src/test/groovy/org/apache/shiro/crypto/

pushd shiro

mvn3 test -pl :shiro-core -am || true

echo "Let's fix the test!"
read

rm ./crypto/core/src/test/groovy/org/apache/shiro/crypto/FailingTest.java

echo "And follow Maven's instruction"

mvn3 test -pl :shiro-core -am -rf :shiro-crypto-core || true

popd

echo Repeat with Maven 4
read

cp  ./demo-99-resources/FailingTest.java ./shiro/crypto/core/src/test/groovy/org/apache/shiro/crypto/

pushd shiro

mvn4 test -pl :shiro-core -am || true

echo "Let's fix the test!"
read

rm ./crypto/core/src/test/groovy/org/apache/shiro/crypto/FailingTest.java

echo "And follow Maven's instruction"
echo "Note: no need to repeat the project list or mention where to resume the build!"

mvn4 test -r

popd
