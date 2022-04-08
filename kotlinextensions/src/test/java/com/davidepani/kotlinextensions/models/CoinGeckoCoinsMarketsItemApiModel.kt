package com.davidepani.kotlinextensions.models


import com.google.gson.annotations.SerializedName

data class CoinGeckoCoinsMarketsItemApiModel(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    @SerializedName("current_price")
    val currentPrice: Double,
    @SerializedName("market_cap")
    val marketCap: Long,
    @SerializedName("market_cap_rank")
    val marketCapRank: Int,
    @SerializedName("fully_diluted_valuation")
    val fullyDilutedValuation: Long,
    @SerializedName("total_volume")
    val totalVolume: Long,
    @SerializedName("high_24h")
    val high24h: Int,
    @SerializedName("low_24h")
    val low24h: Int,
    @SerializedName("price_change_24h")
    val priceChange24h: Double,
    @SerializedName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @SerializedName("market_cap_change_24h")
    val marketCapChange24h: Double,
    @SerializedName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double,
    @SerializedName("circulating_supply")
    val circulatingSupply: Int,
    @SerializedName("total_supply")
    val totalSupply: Int,
    @SerializedName("max_supply")
    val maxSupply: Int,
    val ath: Int,
    @SerializedName("ath_change_percentage")
    val athChangePercentage: Double,
    @SerializedName("ath_date")
    val athDate: String,
    val atl: Double,
    @SerializedName("atl_change_percentage")
    val atlChangePercentage: Double,
    @SerializedName("atl_date")
    val atlDate: String,
    val roi: Any?,
    @SerializedName("last_updated")
    val lastUpdated: String
)