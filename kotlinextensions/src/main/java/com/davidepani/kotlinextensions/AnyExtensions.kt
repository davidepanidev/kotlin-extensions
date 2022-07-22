package com.davidepani.kotlinextensions

import com.davidepani.kotlinextensions.utils.serialization.SerializationManager

fun Any.serializeToJsonString(serializationManager: SerializationManager): String {
    return serializationManager.serializeToJsonString(
        objectToSerialize = this
    )
}