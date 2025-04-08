#!/usr/bin/env bash
set -euo pipefail

if ! command -v java >/dev/null 2>&1 && [ -z "${JAVA_HOME}" ]; then
  >&2 echo "[ERROR] no java in path. Please set JAVA_HOME and PATH."
  exit 1
fi

# if java is not in path, do so now.
if ! command -v java >/dev/null 2>&1; then
  PATH="${JAVA_HOME}/bin:${PATH}"
  export PATH
fi

# check if Java 21 or newer is being used

java_spec_version="$(java -XshowSettings:vm -XshowSettings:properties  --version 2>&1 | grep "java.specification.version")"
java_spec_version="$(echo "$java_spec_version" | cut -f 2 -d "=" | tr -d '[:space:]')"

if [ "${java_spec_version}" -lt 21 ]; then
  >&2 echo "[ERROR] you need java 21, but you are using ${java_spec_version}"
  exit 1
fi

# Delete cache
if [ -e "$HOME/.m2/build-cache/v1/org.apache.shiro" ]; then
  rm -rf "$HOME/.m2/build-cache/v1/org.apache.shiro"*
fi

# Start the Docker container for visualising the build
./startJaeger.sh

# Fetch the Shiro repository
git submodule init
git submodule update --recursive

# Do a one-time build so that we have (most) dependencies and plugins downloaded
pushd shiro
mvn verify -pl '!org.apache.shiro.integrationtests:shiro-its-jakarta-ee'
popd

pushd demo-resources/app-simple
mvnd verify -q -ntp
popd

pushd demo-resources/app-more-modules
mvnd verify -q -ntp
popd
