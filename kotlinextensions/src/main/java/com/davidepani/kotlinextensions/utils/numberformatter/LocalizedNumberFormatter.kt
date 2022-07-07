package com.davidepani.kotlinextensions.utils.numberformatter

import java.text.NumberFormat
import java.util.*

class LocalizedNumberFormatter(
    val locale: Locale = Locale.getDefault(),
    val showAlwaysSign: Boolean = true,
    val maximumFractionDigits: Int = 2,
    val minimumFractionDigits: Int = 2,
    val divideValueBy100: Boolean = false
) : NumberFormatter {

    fun formatToPercentage(
        amount: Number,
        locale: Locale
    ): String {
        val numberFormat = NumberFormat.getPercentInstance(locale).apply {
            maximumFractionDigits = this@LocalizedNumberFormatter.maximumFractionDigits
            minimumFractionDigits = this@LocalizedNumberFormatter.minimumFractionDigits
        }


        val valueToFormat: Double = if (divideValueBy100) amount.toDouble() / 100 else amount.toDouble()
        var formattedValue: String = numberFormat.format(valueToFormat)

        formattedValue = if (!showAlwaysSign) {
            formattedValue
        } else {
            if (formattedValue.startsWith("+") or formattedValue.startsWith("-")) {
                formattedValue
            } else {
                val sign = if (valueToFormat >= 0) "+" else "-"
                sign.plus(formattedValue)
            }
        }

        return formattedValue
    }

    override fun formatToPercentage(amount: Number): String {
        return formatToPercentage(
            amount = amount,
            locale = this.locale
        )
    }

}