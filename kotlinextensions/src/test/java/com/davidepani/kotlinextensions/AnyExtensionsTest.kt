package com.davidepani.kotlinextensions

import com.davidepani.kotlinextensions.utils.serialization.gson.GsonSerializationManager
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class AnyExtensionsTest {

    private val serializationManager = GsonSerializationManager()


    @Test
    fun `serializeToJsonString returns expected serialized String`() {
        val expectedItem = "[0.15,16.1]"
        val objectToSerialize: List<Double> = listOf(
            0.15,
            16.1
        )

        val actualItem: String = objectToSerialize.serializeToJsonString(
            serializationManager = serializationManager
        )

        expectThat(actualItem).isEqualTo(expectedItem)
    }

    @Test
    fun `serializeToJsonString returns expected serialized String which can be deserialized back to the same object`() {
        val expectedItem: List<Number> = listOf(
            0.15,
            16.1
        )

        val serializedObject: String = expectedItem.serializeToJsonString(
            serializationManager = serializationManager
        )

        val actualItem: List<Number> = serializedObject.deserializeAsJson(
            serializationManager = serializationManager
        )

        expectThat(actualItem).isEqualTo(expectedItem)
    }

}