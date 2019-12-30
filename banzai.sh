#!/bin/bash
# Clean
echo "=====cleaning up====="
echo "rm -rf classes mods/play.with.records.jar"
rm -rf classes mods/play.with.records.jar
echo "=====cleaning up finished====="

# Compile
echo "=====compiling====="
echo "javac --enable-preview --release 14 --module-path mods -d classes --module-source-path src $(find src -name "*.java")"
javac --enable-preview --release 14 --module-path mods -d classes --module-source-path src $(find src -name "*.java")
echo "=====compiling finished====="

# Package
echo "=====packaging====="
echo "jar --create --file=mods/play.with.records.jar --main-class=play.with.records.Main -C classes/play.with.records ."
jar --create --file=mods/play.with.records.jar --main-class=play.with.records.Main -C classes/play.with.records .
echo "=====packaging finished====="

# Run
echo "=====running====="
echo "java --enable-preview --module-path mods --module play.with.records"
java --enable-preview --module-path mods --module play.with.records
echo "=====running finished====="