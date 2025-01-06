fastlane documentation
----

# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```sh
xcode-select --install
```

For _fastlane_ installation instructions, see [Installing _fastlane_](https://docs.fastlane.tools/#installing-fastlane)

# Available Actions

## Android

### android test

```sh
[bundle exec] fastlane android test
```

Runs all the tests

### android print

```sh
[bundle exec] fastlane android print
```

print

### android generate

```sh
[bundle exec] fastlane android generate
```

generate debug apk

### android generate_signed_apk

```sh
[bundle exec] fastlane android generate_signed_apk
```

generate signed apk

### android distribute_firebase

```sh
[bundle exec] fastlane android distribute_firebase
```

distribute to firebase

### android clean_app

```sh
[bundle exec] fastlane android clean_app
```

clean project

### android beta_android

```sh
[bundle exec] fastlane android beta_android
```

generate signed apk and distribute on firebase distribution 

### android instrumentation_tests

```sh
[bundle exec] fastlane android instrumentation_tests
```

Run instrumentation tests

----

This README.md is auto-generated and will be re-generated every time [_fastlane_](https://fastlane.tools) is run.

More information about _fastlane_ can be found on [fastlane.tools](https://fastlane.tools).

The documentation of _fastlane_ can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
