package com.davidepani.kotlinextensions.utils.currencyformatter

import com.davidepani.kotlinextensions.utils.currencyformatter.models.CurrencySymbolPosition
import com.davidepani.kotlinextensions.utils.currencyformatter.models.CurrencySymbolSpacing
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.util.*

class CustomCurrencyFormatterTest {

    private val amount = 1200
    private val currencySymbol = "BTC"

    private val cut = CustomCurrencyFormatter(
        currencySymbol = currencySymbol,
        currencySymbolPosition = CurrencySymbolPosition.RIGHT,
        currencySymbolSpacing = CurrencySymbolSpacing.ENABLED
    )

    @Before
    fun setUp() {
        Locale.setDefault(Locale.US)
    }


    @Test
    fun `format with default values returns formatted currency`() {
        val expectedFormattedCurrency = "1,200.00${cut.spacingCharacter}$currencySymbol"

        val actualFormattedCurrency = cut.format(amount = amount)

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

    @Test
    fun `format with symbol position RIGHT and symbol spacing DISABLED returns formatted currency`() {
        val expectedFormattedCurrency = "1,200.00$currencySymbol"

        val actualFormattedCurrency = cut.format(
            amount = amount,
            currencySymbol = currencySymbol,
            currencySymbolPosition = CurrencySymbolPosition.RIGHT,
            currencySymbolSpacing = CurrencySymbolSpacing.DISABLED
        )

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

    @Test
    fun `format with symbol position RIGHT and symbol spacing ENABLED returns formatted currency`() {
        val expectedFormattedCurrency = "1,200.00${cut.spacingCharacter}$currencySymbol"

        val actualFormattedCurrency = cut.format(
            amount = amount,
            currencySymbol = currencySymbol,
            currencySymbolPosition = CurrencySymbolPosition.RIGHT,
            currencySymbolSpacing = CurrencySymbolSpacing.ENABLED
        )

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

    @Test
    fun `format with symbol position LEFT and symbol spacing ENABLED returns formatted currency`() {
        val expectedFormattedCurrency = "$currencySymbol${cut.spacingCharacter}1,200.00"

        val actualFormattedCurrency = cut.format(
            amount = amount,
            currencySymbol = currencySymbol,
            currencySymbolPosition = CurrencySymbolPosition.LEFT,
            currencySymbolSpacing = CurrencySymbolSpacing.ENABLED
        )

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

    @Test
    fun `format with symbol position LEFT and symbol spacing DISABLED returns formatted currency`() {
        val expectedFormattedCurrency = "${currencySymbol}1,200.00"

        val actualFormattedCurrency = cut.format(
            amount = amount,
            currencySymbol = currencySymbol,
            currencySymbolPosition = CurrencySymbolPosition.LEFT,
            currencySymbolSpacing = CurrencySymbolSpacing.DISABLED
        )

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

    @Test
    fun `format with default values and customCurrencySymbol returns formatted currency`() {
        val customCurrencySymbol = "ETH"
        val expectedFormattedCurrency = "1,200.00${cut.spacingCharacter}$customCurrencySymbol"

        val actualFormattedCurrency = cut.format(
            amount = amount,
            customCurrencySymbol = customCurrencySymbol
        )

        expectThat(actualFormattedCurrency).isEqualTo(expectedFormattedCurrency)
    }

}