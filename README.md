# Accelerating Maven Builds: From Snail's Pace to Rocket Speed

This repository contains all the demo's for "Accelerating Maven Builds: From Snail's Pace to Rocket Speed"

## Prerequisites

* You need Mac OS or Linux.
* You need Bash.
* You need Docker with Compose.
* You need to have an `amd64` or `arm64` processor.
  * Maven Daemon comes with a native CLI, which is a separate distribution for each operating system and processor architecture.

## Preparations

Make sure to have a Java 21 runtime installed and ready for use.
The scripts assume that an environment variable `JAVA_HOME` exists and points to the installation directory of a Java 21 runtime.

After cloning this repository, be sure to fetch the example project by running

```bash
git submodule init
git submodule update
```

## Running the demos

To play a particular demo, use the `demo-<n>-<name>.sh` script.

Alternatively, in most cases, running `mvn verify` (or `mvnd verify`) is enough.
To play with parallel tests, activate the Maven profile _parallel-tests_: `-P parallel-tests`.
