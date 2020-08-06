#!/usr/bin/env bash

set -ex

./gradlew clean build
docker-compose build