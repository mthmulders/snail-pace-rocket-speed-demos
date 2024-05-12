#!/usr/bin/env bash

function __debug() {
  # echo ${@}
  true
}

if type brew &>/dev/null; then
  hbdir=${HOMEBREW_PREFIX:-/opt/homebrew}
  __debug "Detected Homebrew in $hbdir" 
  # Find maven-snapshot installation directory
  mvn4dir=$(find $hbdir/Cellar/maven-snapshot -type d -name "4*")
  if [ -f "$mvn4dir/bin/mvn" ] && [ -x "$mvn4dir/bin/mvn" ]; then
    __debug Found Maven 4 at $mvn4dir/bin/mvn and it is executable: $($mvn4dir/bin/mvn --version | head -n 1)
    function mvn4() {
      $mvn4dir/bin/mvn "${@}"
    }
  fi

  # Find maven installation directory
  mvn3dir=$(find $hbdir/Cellar/maven -type d -name "3*")
  if [ -f "$mvn3dir/bin/mvn" ] && [ -x "$mvn3dir/bin/mvn" ]; then
    __debug Found Maven 3 at $mvn3dir/bin/mvn and it is executable: $($mvn3dir/bin/mvn --version | head -n 1)
    function mvn3() {
      $mvn3dir/bin/mvn "${@}"
    }
  fi
fi

# sdkman will overwrite brew, this is intended - as long as it has at least one versio of Maven installed
sdk_maven_dir="${SDKMAN_DIR:-$HOME/.sdkman}/candidates/maven"
if [[ -d "${sdk_maven_dir}" ]]; then
  __debug "SDKMan! has at least one version of Maven"
  mvn4dir="$(find "$sdk_maven_dir" -type d -name "4*" -prune | head -n 1)"
  if [ -f "$mvn4dir/bin/mvn" ]; then
    __debug Found Maven 4 at $mvn4dir/bin/mvn and it is executable: $($mvn4dir/bin/mvn --version | head -n 1)
    function mvn4() {
      "$mvn4dir/bin/mvn" "$@"
    }
  fi

  mvn3dir="$(find "$sdk_maven_dir" -type d -name "3.9*" -prune | head -n 1)"
  if [ -f "$mvn3dir/bin/mvn" ]; then
    __debug Found Maven 3 at $mvn3dir/bin/mvn and it is executable: $($mvn3dir/bin/mvn --version | head -n 1)
    function mvn3() {
      "$mvn3dir/bin/mvn" "$@"
    }
  fi
fi


# See if MVND3_EXEC environment variable is defined and a file exists
if [ -f "$MVND3_EXEC" ]; then
  function mvnd3() {
    $MVND3_EXEC "$@"
  }
else
  # fallback, assume mvnd is on the PATH
  function mvnd3() {
    mvnd "$@"
  }
fi


docker run --rm --name jaeger \
  -e COLLECTOR_ZIPKIN_HOST_PORT=:9411 \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 4317:4317 \
  -p 4318:4318 \
  -p 14250:14250 \
  -p 14268:14268 \
  -p 14269:14269 \
  -p 9411:9411 \
  -d \
  jaegertracing/all-in-one:1.54