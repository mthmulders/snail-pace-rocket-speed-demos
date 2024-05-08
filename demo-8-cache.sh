#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

cp ./demo-8-resources/extensions.xml shiro/.mvn/

pushd shiro

echo "Press enter for a first run"
read var

mvnd3 --file pom.xml test --projects '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'

echo ""
echo "Press enter for a new run"
echo ""
read var

mvnd3 --file pom.xml test --projects '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'

echo ""
read var

echo ""
echo "Now edit the file ./shiro/web/src/main/java/org/apache/shiro/web/servlet/SimpleCookie.java"
echo ""
perl -i.bak -pe 's,null/empty,null or empty,g' "./web/src/main/java/org/apache/shiro/web/servlet/SimpleCookie.java"
rm -f "./web/src/main/java/org/apache/shiro/web/servlet/SimpleCookie.java.bak"
echo ""
read var

mvnd3 --file pom.xml test --projects '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'

popd
