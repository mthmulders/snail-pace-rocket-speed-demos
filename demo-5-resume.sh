#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

# Shiro Crypto Core is one of the first modules in the build and depends on Shiro Lang.
cp  ./demo-5-resources/FailingTest.java ./shiro/crypto/core/src/test/groovy/org/apache/shiro/crypto/

pushd shiro

mvn3 test -pl :shiro-core -am || true

echo "Let's fix the test!"
read var

rm ./crypto/core/src/test/groovy/org/apache/shiro/crypto/FailingTest.java

echo "And follow Maven's instruction"
echo "mvn3 test -pl :shiro-core -am -rf :shiro-crypto-core"

read var

mvn3 test -pl :shiro-core -am -rf :shiro-crypto-core || true

popd

echo Repeat with Maven 4
read var

cp  ./demo-5-resources/FailingTest.java ./shiro/crypto/core/src/test/groovy/org/apache/shiro/crypto/

pushd shiro

mvn4 test -pl :shiro-core -am || true

echo "Let's fix the test!"
read var

rm ./crypto/core/src/test/groovy/org/apache/shiro/crypto/FailingTest.java

echo "And follow Maven's instruction"
echo "Note: no need to repeat the project list or mention where to resume the build!"
echo "mvn4 test -r"

read var

mvn4 test -r

popd
