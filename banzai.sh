#!/bin/bash
# Clean
rm -rf classes mods/play.with.records.jar

# Compile
javac --enable-preview --release 14 --module-path mods -d classes --module-source-path src $(find src -name "*.java")

# Package
jar --create --file=mods/play.with.records.jar --main-class=play.with.records.Main -C classes/play.with.records .

# Run
java --enable-preview --module-path mods --module play.with.records