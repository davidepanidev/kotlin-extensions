package com.davidepani.kotlinextensions

import com.davidepani.kotlinextensions.models.BITCOIN_RESOURCE_JSON_FILENAME
import com.davidepani.kotlinextensions.models.CoinGeckoCoinsMarketsItemApiModel
import com.davidepani.kotlinextensions.utils.deserializer.GsonDeserializer
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class StringExtensionsTest {

    private val deserializer = GsonDeserializer()
    private val deserializedItem: CoinGeckoCoinsMarketsItemApiModel = deserializer.deserializeJsonFileFromSystemResources(
        fileName = BITCOIN_RESOURCE_JSON_FILENAME,
        classOfT = CoinGeckoCoinsMarketsItemApiModel::class.java
    )

    @Test
    fun `deserializeJsonFileFromSystemResources returns expected deserialized item`() {
        val expectedItem = deserializedItem
        val actualItem: CoinGeckoCoinsMarketsItemApiModel = BITCOIN_RESOURCE_JSON_FILENAME.deserializeJsonFileFromSystemResources(
            deserializer = deserializer
        )

        expectThat(actualItem).isEqualTo(expectedItem)
    }

}