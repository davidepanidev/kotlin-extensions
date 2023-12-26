package com.github.davidepanidev.kotlinextensions

import com.github.davidepanidev.kotlinextensions.utils.currencyformatter.CurrencyFormatter
import com.github.davidepanidev.kotlinextensions.utils.numberformatter.NumberFormatter
import java.math.RoundingMode
import java.time.LocalDateTime
import java.time.ZoneOffset


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

fun Long.toLocalDateTime(offset: ZoneOffset = ZoneOffset.UTC): LocalDateTime {
    return LocalDateTime.ofEpochSecond(this, 0, offset)
}

fun Double.roundToNDecimals(decimals: Int, roundingMode: RoundingMode = RoundingMode.UP): Double {
    return this.toBigDecimal().setScale(decimals, roundingMode).toDouble()
}