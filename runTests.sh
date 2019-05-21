#!/usr/bin/env bash

mvn gatling:test -DProfile='single' --fail-at-end --batch-mode --update-snapshots