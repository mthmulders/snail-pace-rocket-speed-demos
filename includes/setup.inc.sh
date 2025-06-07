#!/usr/bin/env bash

CWD=$(pwd)

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
fi

# See if Apache Maven 3.9.10 is already downloaded
if [ -f "$CWD/.downloads/apache-maven-3.9.10/bin/mvn" ]; then
  __debug "Found Apache Maven 3.9.10 at $CWD/.downloads/apache-maven-3.9.10/bin/mvn"
else
  __debug "Apache Maven 3.9.10 not found at $CWD/.downloads/apache-maven-3.9.10/bin/mvn"
  pushd "$CWD/.downloads" || exit 1
  __debug "Downloading Apache Maven 3.9.10"
  curl -L -O https://dlcdn.apache.org/maven/maven-3/3.9.10/binaries/apache-maven-3.9.10-bin.tar.gz
  tar -xzf apache-maven-3.9.10-bin.tar.gz
  rm apache-maven-3.9.10-bin.tar.gz
  popd
fi

# See if Apache Maven 4.0.0-rc-2 is already downloaded.
# Yes, rc-3 is already available, but it has a few bugs that would be annoying in the demos.
if [ -f "$CWD/.downloads/apache-maven-4.0.0-rc-2/bin/mvn" ]; then
  __debug "Found Apache Maven 4.0.0-rc-2 at $CWD/.downloads/apache-maven-4.0.0-rc-2/bin/mvn"
else
  __debug "Apache Maven 3.9.10 not found at $CWD/.downloads/apache-maven-3.9.10/bin/mvn"
  pushd "$CWD/.downloads" || exit 1
  __debug "Downloading Apache Maven 4.0.0-rc-2"
  curl -L -O https://archive.apache.org/dist/maven/maven-4/4.0.0-rc-2/apache-maven-4.0.0-rc-2-bin.tar.gz
  tar -xzf apache-maven-4.0.0-rc-2-bin.tar.gz
  rm apache-maven-4.0.0-rc-2-bin.tar.gz
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

# See if Apache Maven Daemon 1.0.2 is already downloaded
if [ -f "$CWD/.downloads/maven-mvnd-1.0.2-$MVND_OS-$MVND_ARCH/bin/mvnd" ]; then
  __debug "Found Apache Maven Daemon 1.0.2 at $CWD/.downloads/maven-mvnd-1.0.2-$MVND_OS-$MVND_ARCH/bin/mvnd"
else
  __debug "Apache Maven Daemon 1.0.2 not found at $CWD/.downloads/maven-mvnd-1.0.2-$MVND_OS-$MVND_ARCH/bin/mvnd"
  if [[ $MVND_OS == "linux" && $MVND_ARCH == "aarch64" ]]; then
    __debug "Apache Maven Daemon 1.0.2 is not available for Linux ARM64, skipping download."
  else
    pushd "$CWD/.downloads" || exit 1
    __debug "Downloading Apache Maven Daemon 1.0.2"
    curl -L -O https://dlcdn.apache.org/maven/mvnd/1.0.2/maven-mvnd-1.0.2-$MVND_OS-$MVND_ARCH.tar.gz
    tar -xzf maven-mvnd-1.0.2-$MVND_OS-$MVND_ARCH.tar.gz
    rm maven-mvnd-1.0.2-$MVND_OS-$MVND_ARCH.tar.gz
    popd
  fi
fi

# Create a `mvn3` function to use the downloaded Maven 3.9.10
function mvn3() {
  "$CWD/.downloads/apache-maven-3.9.10/bin/mvn" "$@"
}

# Create a `mvnd3` function to use the downloaded Maven Daemon 1.0.2
function mvnd3() {
  "$CWD/.downloads/maven-mvnd-1.0.2-$MVND_OS-$MVND_ARCH/bin/mvnd" "$@"
}

# Create a `mvn4` function to use the downloaded Maven 4.0.0-rc-2
function mvn4() {
  "$CWD/.downloads/apache-maven-4.0.0-rc-2/bin/mvn" "$@"
}