#!/usr/bin/env bash
set -x

if ! command -v mvn3 >/dev/null; then
  alias mvn3='mvn '
  function mvn3() {
      mvn "${@}"
  }
fi
