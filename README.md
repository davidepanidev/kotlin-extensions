# Kotlin Extensions

[![Kotlin](https://img.shields.io/badge/kotlin-1.7.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/github/license/davidepanidev/kotlin-extensions?color=orange)]()
[![Version](https://img.shields.io/jitpack/version/com.github.davidepanidev/kotlin-extensions?color=red&label=JitPack)](https://jitpack.io/#davidepanidev/kotlin-extensions)
[![Snyk Security Scan](https://img.shields.io/snyk/vulnerabilities/github/davidepanidev/kotlin-extensions)](https://snyk.io/test/github/davidepanidev/kotlin-extensions)

Kotlin helper functions to be used in JVM environments, built following SOLID principles.


## Including in your project

### Gradle
Add the code below to your **root** `build.gradle` file (not your module build.gradle file):
```gradle
allprojects {
    repositories {
        ..
        maven { url 'https://jitpack.io' }
    }
}
```

Next, add the dependency below to your **module**'s `build.gradle` file:

```gradle
dependencies {
    implementation "com.github.davidepanidev:kotlin-extensions:2.0"
}
```
