package com.davidepani.kotlinextensions

import com.davidepani.kotlinextensions.utils.currencyformatter.CurrencyFormatter
import com.davidepani.kotlinextensions.utils.numberformatter.NumberFormatter


fun Number.formatToCurrency(currencyFormatter: CurrencyFormatter): String {
    return currencyFormatter.format(
        amount = this
    )
}

fun Number.formatToCurrency(currencyFormatter: CurrencyFormatter, customCurrencySymbol: String): String {
    return currencyFormatter.format(
        amount = this,
        customCurrencySymbol = customCurrencySymbol
    )
}

fun Number.formatToPercentage(numberFormatter: NumberFormatter): String {
    return numberFormatter.formatToPercentage(amount = this)
}