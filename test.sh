#!/usr/bin/env bash
IFS=$'\n\t'

. ./includes/setup.inc.sh

set -euox pipefail

mvn3 -v
mvn4 -v
mvnd3 -v