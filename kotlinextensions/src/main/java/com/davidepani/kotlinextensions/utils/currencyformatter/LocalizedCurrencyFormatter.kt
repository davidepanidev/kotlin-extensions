package com.davidepani.kotlinextensions.utils.currencyformatter

import java.text.NumberFormat
import java.util.*

class LocalizedCurrencyFormatter(
    val locale: Locale = Locale.getDefault(),
    val currencyLocale: Locale = Locale.getDefault()
) : CurrencyFormatter {

    fun format(
        amount: Number,
        locale: Locale,
        currencyLocale: Locale
    ): String {
        val numberFormat = NumberFormat.getCurrencyInstance(locale).apply {
            maximumFractionDigits = 2
            currency = Currency.getInstance(currencyLocale)
        }

        return numberFormat.format(amount)
    }

    override fun format(amount: Number): String {
        return this.format(
            amount = amount,
            locale = this.locale,
            currencyLocale = this.currencyLocale
        )
    }

    override fun format(amount: Number, customCurrencySymbol: String): String {
        val trimmedSymbol = customCurrencySymbol.trim()
        val localizedFormat = this.format(
            amount = amount,
            locale = this.locale,
            currencyLocale = this.currencyLocale
        )

        return localizedFormat.replace(Currency.getInstance(this.currencyLocale).symbol, trimmedSymbol)
    }

}