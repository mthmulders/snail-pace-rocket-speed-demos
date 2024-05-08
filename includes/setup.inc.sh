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

# sdkman will overwrite brew, this is intended.
sdkdir="${SDKMAN_DIR:-$HOME/.sdkman}"
if [[ -n "${sdkdir}" ]]; then
  mvn4dir="$(find "$sdkdir/candidates/maven" -type d -name "4*" -prune | head -n 1)"
  if [ -f "$mvn4dir/bin/mvn" ]; then
    __debug Found Maven 4 at $mvn4dir/bin/mvn and it is executable: $($mvn4dir/bin/mvn --version | head -n 1)
    function mvn4() {
      "$mvn4dir/bin/mvn" "$@"
    }
  fi

  mvn3dir="$(find "$sdkdir/candidates/maven" -type d -name "3.9*" -prune | head -n 1)"
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

