#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

cp demo-2-resources/extensions.xml shiro/.mvn/

pushd shiro

mvn3 clean -q 

echo ""
echo "Executing default build in sequence!"
echo ""
read var
mvn3 verify --projects :shiro-core --also-make -Dotel.traces.exporter=otlp || true

read var

echo ""
echo "Let's execute tests in parallel!"
echo ""
# config/ogdl tests are not thread safe
# "config/ogdl"
for moddir in "lang" "crypto/core" "crypto/hash" "crypto/support/hashes/argon2" "crypto/support/hashes/bcrypt" "event" "cache" "config/core" "core"; do
  mkdir -p "$moddir/src/test/resources" || true
  cp ../demo-2-resources/junit-platform.properties "$moddir/src/test/resources/" || true
done

echo ""
echo "now fix a not-threadsafe test"
echo ""

perl -0777 -i.bak -pe 's/\nclass DefaultPasswordServiceTest/\n\@org.junit.jupiter.api.parallel.Execution(org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD)\nclass DefaultPasswordServiceTest/igs' "./core/src/test/groovy/org/apache/shiro/authc/credential/DefaultPasswordServiceTest.groovy"
perl -0777 -i.bak -pe 's/\npublic class JDBCRealmTest/\n\@org.junit.jupiter.api.parallel.Execution(org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD)\npublic class JDBCRealmTest/igs' "./core/src/test/java/org/apache/shiro/realm/jdbc/JDBCRealmTest.java"

rm "./core/src/test/groovy/org/apache/shiro/authc/credential/DefaultPasswordServiceTest.groovy.bak"
rm "./core/src/test/java/org/apache/shiro/realm/jdbc/JDBCRealmTest.java.bak"


echo ""
echo "Press enter to execute maven again"
echo ""
read var
mvn3 verify --projects :shiro-core --also-make -Dotel.traces.exporter=otlp || true

popd

