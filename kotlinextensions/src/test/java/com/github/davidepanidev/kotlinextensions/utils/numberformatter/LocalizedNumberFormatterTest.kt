package com.github.davidepanidev.kotlinextensions.utils.numberformatter

import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.util.*

class LocalizedNumberFormatterTest {

    private val cut = LocalizedNumberFormatter(
        locale = Locale.ITALY,
        showAlwaysSign = true,
        maximumFractionDigits = 2,
        minimumFractionDigits = 2,
        divideValueBy100 = true
    )


    @Test
    fun `formatToPercentage with default Locale and positive amount returns formatted percentage`() {
        val amount = 1200
        val expectedFormattedPercentage = "+1.200,00%"

        val actualFormattedPercentage = cut.formatToPercentage(amount = amount)

        expectThat(actualFormattedPercentage).isEqualTo(expectedFormattedPercentage)
    }

    @Test
    fun `formatToPercentage with default Locale and negative amount returns formatted percentage`() {
        val amount = -1200
        val expectedFormattedPercentage = "-1.200,00%"

        val actualFormattedPercentage = cut.formatToPercentage(amount = amount)

        expectThat(actualFormattedPercentage).isEqualTo(expectedFormattedPercentage)
    }

    @Test
    fun `formatToPercentage with default decimal amount returns formatted percentage`() {
        val amount = 0.342122
        val expectedFormattedPercentage = "+0,34%"

        val actualFormattedPercentage = cut.formatToPercentage(amount = amount)

        expectThat(actualFormattedPercentage).isEqualTo(expectedFormattedPercentage)
    }

    @Test
    fun `formatToPercentage with custom Locale and positive amount returns formatted percentage`() {
        val amount = 1200
        val locale = Locale.US
        val expectedFormattedPercentage = "+1,200.00%"

        val actualFormattedPercentage = cut.formatToPercentage(
            amount = amount,
            locale = locale
        )

        expectThat(actualFormattedPercentage).isEqualTo(expectedFormattedPercentage)
    }

}