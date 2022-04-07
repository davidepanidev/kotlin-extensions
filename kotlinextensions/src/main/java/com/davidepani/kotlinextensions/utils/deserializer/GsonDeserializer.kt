package com.davidepani.kotlinextensions.utils.deserializer

import com.google.gson.Gson

class GsonDeserializer : Deserializer {

    private val gson = Gson()

    override fun <T> deserializeJsonFileFromSystemResources(
        fileName: String,
        classOfT: Class<T>
    ): T {
        val jsonText = ClassLoader.getSystemResource(fileName).readText()
        return gson.fromJson(jsonText, classOfT)
    }

}