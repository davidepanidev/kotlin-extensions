package com.davidepani.kotlinextensions.utils.deserializer

interface Deserializer {

    fun <T> deserializeJsonFileFromSystemResources(fileName: String, classOfT: Class<T>): T

}