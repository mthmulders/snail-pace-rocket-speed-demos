#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd shiro

mvn3 clean -q 

echo ""
echo "Executing default build in sequence!"
echo ""
read var
mvn3 verify -pl :shiro-core -am || true

read var

echo ""
echo "Let's execute tests in parallel!"
echo ""
# config/ogdl tests are not thread safe
# "config/ogdl"
for moddir in "lang" "crypto/core" "crypto/hash" "crypto/support/hashes/argon2" "crypto/support/hashes/bcrypt" "event" "cache" "config/core" "core"; do
  mkdir -p "$moddir/src/test/resources" || true
  cp ../junit-platform.properties "$moddir/src/test/resources/" || true
done

echo ""
echo "now fix a not-threadsafe test"
echo ""
perl -0777 -i.bak -pe 's/\nclass DefaultPasswordServiceTest/\n\@org.junit.jupiter.api.parallel.Execution(org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD)\nclass DefaultPasswordServiceTest/igs' "./core/src/test/groovy/org/apache/shiro/authc/credential/DefaultPasswordServiceTest.groovy"
rm "./core/src/test/groovy/org/apache/shiro/authc/credential/DefaultPasswordServiceTest.groovy.bak"


echo ""
echo "Press enter to execute maven again"
echo ""
read var
mvn3 verify -pl :shiro-core -am || true

popd

