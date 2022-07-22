package com.davidepani.kotlinextensions.utils.serialization.gson

import com.davidepani.kotlinextensions.utils.serialization.SerializationManager
import com.google.gson.Gson

class GsonSerializationManager : SerializationManager {

    private val gson = Gson()


    override fun serializeToJsonString(objectToSerialize: Any): String {
        return gson.toJson(objectToSerialize)
    }

    override fun <T> deserializeJsonFromString(json: String, classOfT: Class<T>): T {
        return gson.fromJson(json, classOfT)
    }

    override fun <T> deserializeJsonFileFromSystemResources(
        fileName: String,
        classOfT: Class<T>
    ): T {
        val jsonText = ClassLoader.getSystemResource(fileName).readText()
        return deserializeJsonFromString(json = jsonText, classOfT = classOfT)
    }

}