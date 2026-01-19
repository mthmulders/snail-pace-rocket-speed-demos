#!/usr/bin/env bash

CWD=$(pwd)
MAVEN_3_VERSION="3.9.9"
# Yes, rc-3 is already available, but it has a few bugs that would be annoying in the demos.
MAVEN_4_VERSION="4.0.0-rc-2"
MVND_VERSION="1.0.3"

mkdir -p $CWD/.downloads

function __debug() {
  echo ${@}
}

jaeger_status=$(docker inspect demos-jaeger-1 --format='{{.State.Status}}' 2>&1)
if [[ "$jaeger_status" == "running" ]]; then
    __debug "Jaeger is already running."
else
    __debug "Jaeger is not running. Starting Jaeger..."
    pushd demos
    docker-compose up -d jaeger
    popd
fi

# See if Apache Maven 3.x is already downloaded
if [ -f "$CWD/.downloads/apache-maven-$MAVEN_3_VERSION/bin/mvn" ]; then
  __debug "Found Apache Maven $MAVEN_3_VERSION at $CWD/.downloads/apache-maven-$MAVEN_3_VERSION/bin/mvn"
else
  __debug "Apache Maven $MAVEN_3_VERSION not found at $CWD/.downloads/apache-maven-$MAVEN_3_VERSION/bin/mvn"
  pushd "$CWD/.downloads" || exit 1
  __debug "Downloading Apache Maven $MAVEN_3_VERSION"
  curl -L -O https://archive.apache.org/dist/maven/maven-3/$MAVEN_3_VERSION/binaries/apache-maven-$MAVEN_3_VERSION-bin.tar.gz
  tar -xzf apache-maven-$MAVEN_3_VERSION-bin.tar.gz
  rm apache-maven-$MAVEN_3_VERSION-bin.tar.gz
  popd
fi

# See if Apache Maven 4.x is already downloaded.
if [ -f "$CWD/.downloads/apache-maven-$MAVEN_4_VERSION/bin/mvn" ]; then
  __debug "Found Apache Maven $MAVEN_4_VERSION at $CWD/.downloads/apache-maven-$MAVEN_4_VERSION/bin/mvn"
else
  __debug "Apache Maven $MAVEN_4_VERSION not found at $CWD/.downloads/apache-maven-$MAVEN_4_VERSION/bin/mvn"
  pushd "$CWD/.downloads" || exit 1
  __debug "Downloading Apache Maven $MAVEN_4_VERSION"
  curl -L -O https://archive.apache.org/dist/maven/maven-4/$MAVEN_4_VERSION/apache-maven-$MAVEN_4_VERSION-bin.tar.gz
  tar -xzf apache-maven-$MAVEN_4_VERSION-bin.tar.gz
  rm apache-maven-$MAVEN_4_VERSION-bin.tar.gz
  popd
fi

# Helper variables for Apache Maven Daemon
MVND_OS=$(uname -s | tr '[:upper:]' '[:lower:]')
MVND_ARCH=$(uname -m | tr '[:upper:]' '[:lower:]')
if [[ $MVND_ARCH == "arm64" ]]; then
  MVND_ARCH="aarch64"
elif [[ $MVND_ARCH == "x86_64" ]]; then
  MVND_ARCH="amd64"
fi

# See if Apache Maven Daemon is already downloaded
if [ -f "$CWD/.downloads/maven-mvnd-$MVND_VERSION-$MVND_OS-$MVND_ARCH/bin/mvnd" ]; then
  __debug "Found Apache Maven Daemon $MVND_VERSION at $CWD/.downloads/maven-mvnd-$MVND_VERSION-$MVND_OS-$MVND_ARCH/bin/mvnd"
else
  __debug "Apache Maven Daemon $MVND_VERSION not found at $CWD/.downloads/maven-mvnd-$MVND_VERSION-$MVND_OS-$MVND_ARCH/bin/mvnd"
  if [[ $MVND_OS == "linux" && $MVND_ARCH == "aarch64" ]]; then
    __debug "Apache Maven Daemon $MVND_VERSION is not available for Linux ARM64, skipping download."
  else
    pushd "$CWD/.downloads" || exit 1
    __debug "Downloading Apache Maven Daemon $MVND_VERSION"
    curl -L -O https://dlcdn.apache.org/maven/mvnd/$MVND_VERSION/maven-mvnd-$MVND_VERSION-$MVND_OS-$MVND_ARCH.tar.gz
    tar -xzf maven-mvnd-$MVND_VERSION-$MVND_OS-$MVND_ARCH.tar.gz
    rm maven-mvnd-$MVND_VERSION-$MVND_OS-$MVND_ARCH.tar.gz
    popd
  fi
fi

# Create a `mvn3` function to use the downloaded Maven 3.x
function mvn3() {
  "$CWD/.downloads/apache-maven-$MAVEN_3_VERSION/bin/mvn" "$@"
}

# Create a `mvnd3` function to use the downloaded Maven Daemon
function mvnd3() {
  "$CWD/.downloads/maven-mvnd-$MVND_VERSION-$MVND_OS-$MVND_ARCH/bin/mvnd" "$@"
}

# Create a `mvn4` function to use the downloaded Maven 4.x
function mvn4() {
  "$CWD/.downloads/apache-maven-$MAVEN_4_VERSION/bin/mvn" "$@"
}
