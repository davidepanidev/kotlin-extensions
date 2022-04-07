package com.davidepani.kotlinextensions

import com.davidepani.kotlinextensions.utils.deserializer.Deserializer


inline fun<reified T> String.deserializeJsonFileFromSystemResources(deserializer: Deserializer): T {
    return deserializer.deserializeJsonFileFromSystemResources(
        fileName = this,
        classOfT = T::class.java
    )
}

