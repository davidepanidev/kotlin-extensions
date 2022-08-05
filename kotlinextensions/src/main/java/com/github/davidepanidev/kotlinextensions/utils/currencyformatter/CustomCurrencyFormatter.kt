package com.github.davidepanidev.kotlinextensions.utils.currencyformatter

import com.github.davidepanidev.kotlinextensions.utils.currencyformatter.models.CurrencySymbolPosition
import com.github.davidepanidev.kotlinextensions.utils.currencyformatter.models.CurrencySymbolSpacing
import java.text.NumberFormat
import java.util.*

class CustomCurrencyFormatter(
    val currencySymbol: String = Currency.getInstance(Locale.getDefault()).symbol,
    val currencySymbolPosition: CurrencySymbolPosition = CurrencySymbolPosition.RIGHT,
    val currencySymbolSpacing: CurrencySymbolSpacing = CurrencySymbolSpacing.ENABLED
) : CurrencyFormatter {

    val spacingCharacter = Typography.nbsp

    fun format(
        amount: Number,
        currencySymbol: String,
        currencySymbolPosition: CurrencySymbolPosition,
        currencySymbolSpacing: CurrencySymbolSpacing
    ): String {
        val formattedAmountWithoutCurrencySymbol = NumberFormat.getNumberInstance().apply {
            minimumFractionDigits = 2
            maximumFractionDigits = 2
        }.format(amount)

        val trimmedCurrencySymbol = currencySymbol.trim()

        return when (currencySymbolPosition) {
            CurrencySymbolPosition.LEFT -> when (currencySymbolSpacing) {
                CurrencySymbolSpacing.ENABLED -> "$trimmedCurrencySymbol${spacingCharacter}$formattedAmountWithoutCurrencySymbol"
                CurrencySymbolSpacing.DISABLED -> "$trimmedCurrencySymbol$formattedAmountWithoutCurrencySymbol"
            }
            CurrencySymbolPosition.RIGHT -> when (currencySymbolSpacing) {
                CurrencySymbolSpacing.ENABLED -> "$formattedAmountWithoutCurrencySymbol${spacingCharacter}$trimmedCurrencySymbol"
                CurrencySymbolSpacing.DISABLED -> "$formattedAmountWithoutCurrencySymbol$trimmedCurrencySymbol"
            }
        }
    }

    override fun format(amount: Number): String {
        return this.format(
            amount = amount,
            currencySymbol = this.currencySymbol,
            currencySymbolPosition = this.currencySymbolPosition,
            currencySymbolSpacing = this.currencySymbolSpacing
        )
    }

    override fun format(amount: Number, customCurrencySymbol: String): String {
        return this.format(
            amount = amount,
            currencySymbol = customCurrencySymbol,
            currencySymbolPosition = this.currencySymbolPosition,
            currencySymbolSpacing = this.currencySymbolSpacing
        )
    }

}