#!/usr/bin/env bash

set -ex

./build.sh
docker-compose up --remove-orphans