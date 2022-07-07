package com.davidepani.kotlinextensions.utils.currencyformatter

interface CurrencyFormatter {

    fun format(amount: Number): String
    fun format(amount: Number, customCurrencySymbol: String): String

}