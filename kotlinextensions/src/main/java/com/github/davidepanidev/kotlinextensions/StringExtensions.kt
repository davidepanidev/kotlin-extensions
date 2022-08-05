package com.github.davidepanidev.kotlinextensions

import com.github.davidepanidev.kotlinextensions.utils.serialization.SerializationManager


inline fun<reified T> String.deserializeJsonFileFromSystemResources(serializationManager: SerializationManager): T {
    return serializationManager.deserializeJsonFileFromSystemResources(
        fileName = this,
        classOfT = T::class.java
    )
}

inline fun<reified T> String.deserializeAsJson(serializationManager: SerializationManager): T {
    return serializationManager.deserializeJsonFromString(
        json = this,
        classOfT = T::class.java
    )
}

