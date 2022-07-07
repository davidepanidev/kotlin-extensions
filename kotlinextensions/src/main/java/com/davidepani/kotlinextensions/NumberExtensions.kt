package com.davidepani.kotlinextensions

import com.davidepani.kotlinextensions.utils.currencyformatter.CurrencyFormatter


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