package com.github.davidepanidev.kotlinextensions

import com.github.davidepanidev.kotlinextensions.models.BITCOIN_RESOURCE_JSON_FILENAME
import com.github.davidepanidev.kotlinextensions.models.CoinGeckoCoinsMarketsItemApiModel
import com.github.davidepanidev.kotlinextensions.utils.serialization.gson.GsonSerializationManager
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class StringExtensionsTest {

    private val serializationManager = GsonSerializationManager()


    @Test
    fun `deserializeJsonFileFromSystemResources returns expected deserialized item`() {
        val expectedItem = deserializedItem
        val actualItem: CoinGeckoCoinsMarketsItemApiModel = BITCOIN_RESOURCE_JSON_FILENAME.deserializeJsonFileFromSystemResources(
            serializationManager = serializationManager
        )

        expectThat(actualItem).isEqualTo(expectedItem)
    }

    @Test
    fun `deserializeAsJson returns expected deserialized item`() {
        val expectedItem = deserializedItem

        val actualItem: CoinGeckoCoinsMarketsItemApiModel = jsonString.deserializeAsJson(
            serializationManager = serializationManager
        )

        expectThat(actualItem).isEqualTo(expectedItem)
    }


    private val deserializedItem: CoinGeckoCoinsMarketsItemApiModel = serializationManager.deserializeJsonFileFromSystemResources(
        fileName = BITCOIN_RESOURCE_JSON_FILENAME,
        classOfT = CoinGeckoCoinsMarketsItemApiModel::class.java
    )

    private val jsonString = """
        {
          "id": "bitcoin",
          "symbol": "btc",
          "name": "Bitcoin",
          "image": "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579",
          "current_price": 43562,
          "market_cap": 829166046390,
          "market_cap_rank": 1,
          "fully_diluted_valuation": 916191451202,
          "total_volume": 29462040769,
          "high_24h": 44944,
          "low_24h": 42867,
          "price_change_24h": -1314.746007100555,
          "price_change_percentage_24h": -2.92967,
          "market_cap_change_24h": -22632325850.011597,
          "market_cap_change_percentage_24h": -2.65701,
          "circulating_supply": 19005293,
          "total_supply": 21000000,
          "max_supply": 21000000,
          "ath": 69045,
          "ath_change_percentage": -36.80612,
          "ath_date": "2021-11-10T14:24:11.849Z",
          "atl": 67.81,
          "atl_change_percentage": 64245.53957,
          "atl_date": "2013-07-06T00:00:00.000Z",
          "roi": null,
          "last_updated": "2022-04-07T13:07:02.711Z"
        }
    """.trimIndent()

}