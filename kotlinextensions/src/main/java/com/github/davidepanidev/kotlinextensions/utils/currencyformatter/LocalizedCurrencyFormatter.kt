package com.github.davidepanidev.kotlinextensions.utils.currencyformatter

import java.text.NumberFormat
import java.util.*

class LocalizedCurrencyFormatter(
    val locale: Locale = Locale.getDefault(),
    val currency: Currency = try {
        Currency.getInstance(Locale.getDefault())
    } catch (e: Exception) {
        Currency.getInstance(Locale.US)
    },
    val maximumFractionDigits: Int = 2,
    val minimumFractionDigits: Int = 2
) : CurrencyFormatter {

    fun format(
        amount: Number,
        locale: Locale,
        currency: Currency
    ): String {
        val numberFormat = NumberFormat.getCurrencyInstance(locale).apply {
            minimumFractionDigits = this@LocalizedCurrencyFormatter.minimumFractionDigits
            maximumFractionDigits = this@LocalizedCurrencyFormatter.maximumFractionDigits
            this.currency = currency
        }

        return numberFormat.format(amount)
    }

    override fun format(amount: Number): String {
        return this.format(
            amount = amount,
            locale = this.locale,
            currency = this.currency
        )
    }

    override fun format(amount: Number, customCurrencySymbol: String): String {
        val trimmedSymbol = customCurrencySymbol.trim()
        val localizedFormat = this.format(
            amount = amount,
            locale = this.locale,
            currency = this.currency
        )

        return localizedFormat.replace(this.currency.symbol, trimmedSymbol)
    }

}