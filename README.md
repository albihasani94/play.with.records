# Play with records

This repo demonstrates the evolution from heavyweight Java objects to the concept of records as data stores.

## Useful Commands

> --enable-preview must be added to the javac and java in order to enable the records preview

```bash
javac --enable-preview --release 14 --module-path mods -d classes --module-source-path src $(find src -name "*.java")
```

```bash
jar --create --file=mods/play.with.records.jar --main-class=play.with.records.Main -C classes/play.with.records .
```

```bash
java --enable-preview --module-path mods --module play.with.records
```