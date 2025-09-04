#!/usr/bin/env bash
set -uo pipefail
# no set -x; if a file or container isn't there, it's OK

rm demo-resources/.mvn/extensions.xml 2>/dev/null || true
find demo-resources/ -name "junit-platform.properties" -exec rm '{}' +

(cd demo-resources && git clean -fxd && git reset --hard HEAD)

rm -Rf ~/.m2/build-cache/v1/de.bmarwell.snailspace.demo4*
rm -Rf ~/.m2/build-cache/v1.1/de.bmarwell.snailspace.demo4*
