package com.github.davidepanidev.kotlinextensions

import com.github.davidepanidev.kotlinextensions.utils.serialization.SerializationManager

fun Any.serializeToJsonString(serializationManager: SerializationManager): String {
    return serializationManager.serializeToJsonString(
        objectToSerialize = this
    )
}