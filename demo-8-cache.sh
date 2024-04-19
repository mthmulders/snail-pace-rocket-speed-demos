#!/usr/bin/env bash
set -xeuo pipefail
IFS=$'\n\t'

. ./includes/setup.inc.sh

cp ./demo-8-resources/extensions.xml shiro/.mvn/

pushd shiro

echo "Press enter for a first run"
read var

mvn3 --file pom.xml verify --projects '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'

echo "Press enter for a new run"
read var

mvn3 --file pom.xml verify --projects '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'

echo "Now edit the file ./shiro/web/src/main/java/org/apache/shiro/web/servlet/SimpleCookie.java"
echo "e.g. Timzone 'GMT' to 'UTC'"
read var

mvn3 --file pom.xml verify --projects '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'

popd
