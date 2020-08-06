#!/usr/bin/env bash

set -ex

./gradlew bootBuildImage
docker-compose build