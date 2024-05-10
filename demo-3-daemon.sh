#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

pushd shiro

echo 
echo Clean up earlier builds
echo 
read 
mvnd3 clean

echo 
echo Perform a build using regular Maven 3
echo 
read 
mvn3 verify -pl :shiro-core -am

echo 
echo Clean up earlier builds
echo 
read 
mvnd3 clean

echo 
echo Perform a build using Maven Daemon 3
echo 
read 
mvnd3 verify -pl :shiro-core -am