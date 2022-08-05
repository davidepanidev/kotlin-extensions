# Kotlin Extensions

[![Kotlin](https://img.shields.io/badge/kotlin-1.7.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/github/license/davidepanidev/kotlin-extensions?color=orange)]()

Kotlin library containing utilities and extension functions.


## Including in your project

[![Version](https://jitpack.io/v/davidepanidev/kotlin-extensions.svg)](https://jitpack.io/#davidepanidev/kotlin-extensions)

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
    implementation "com.github.davidepanidev:kotlin-extensions:0.1"
}
```