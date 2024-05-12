# Accelerating Maven Builds: From Snail's Pace to Rocket Speed
This repository contains all the demo's for "Accelerating Maven Builds: From Snail's Pace to Rocket Speed"

## Prerequisites

* You need Java 21
* You need Maven 3.9.x installed
* For some demos you also need a [recent Maven 4 build](https://maven.apache.org/download.cgi#alpha-4-x-release). Some convenience options:
    * Through a [Homebrew tap](https://github.com/mthmulders/homebrew-maven-snapshot/)
    * Through [Chocolatey](https://community.chocolatey.org/packages/maven-snapshot)
    * Through [Scoop](https://github.com/ScoopInstaller/Versions/pull/1682)
* For some demos you also need a [Maven Daemon with Maven 3](https://github.com/apache/maven-mvnd/releases). Point the scripts to its main executable by defining a variable `MVND3_EXEC` - or add the `mvnd` executable to your `PATH`.

## Preparations

Run `./prepare.sh` to 
- download all the libraries and plugins and Docker containers used by the demo project.
- update the Shiro submodule.

## Cleaning up in between demos

After each demo, run `./clean.sh` to undo any modifications to the Shiro project.
