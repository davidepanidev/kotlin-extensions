package com.github.davidepanidev.kotlinextensions.utils.serialization

/**
 * Handler of either serialization and deserialization of generic objects
 */
interface SerializationManager {

    /**
     * Serializes the input object into a json formatted string.
     * The String can be deserialized back using the [SerializationManager.deserializeJsonFromString] method.
     */
    fun serializeToJsonString(objectToSerialize: Any): String

    /**
     * Deserializes the input json string into an object of the specified class type.
     */
    fun <T> deserializeJsonFromString(json: String, classOfT: Class<T>): T

    /**
     * Deserializes the json file retrieved with [ClassLoader.getSystemResource] into an object of the specified class type.
     */
    fun <T> deserializeJsonFileFromSystemResources(fileName: String, classOfT: Class<T>): T

}