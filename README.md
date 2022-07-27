# Kotlin Extensions

[![Version](https://jitpack.io/v/davide-pani/kotlin-extensions.svg)](https://jitpack.io/#davide-pani/kotlin-extensions)
[![Kotlin](https://img.shields.io/badge/kotlin-1.7.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/github/license/davide-pani/kotlin-extensions?color=orange)]()

Kotlin library containing utilities and extension functions.


## Including in your project

[![Version](https://jitpack.io/v/davide-pani/kotlin-extensions.svg)](https://jitpack.io/#davide-pani/kotlin-extensions)

### Gradle
Add the code below to your **root** `build.gradle` file (not your module build.gradle file):
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Next, add the dependency below to your **module**'s `build.gradle` file:

```gradle
dependencies {
    implementation "com.github.davide-pani:kotlin-extensions:1.5.1"
}
```