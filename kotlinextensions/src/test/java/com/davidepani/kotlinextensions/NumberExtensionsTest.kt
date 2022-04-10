package com.davidepani.kotlinextensions

import com.davidepani.kotlinextensions.utils.currencyformatter.CurrencyFormatter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class NumberExtensionsTest {

    @MockK private lateinit var currencyFormatter: CurrencyFormatter

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }


    @Test
    fun `formatToCurrency calls format method of the provided CurrencyFormatter with correct amount`() {
        val amount = 1
        every { currencyFormatter.format(any()) } returns ""

        amount.formatToCurrency(
            currencyFormatter = currencyFormatter
        )

        verify { currencyFormatter.format(amount) }
    }

    @Test
    fun `formatToCurrency returns fakeFormattedAmount`() {
        val amount = 12
        val fakeFormattedAmount = "12,00 €"

        every { currencyFormatter.format(amount) } returns fakeFormattedAmount

        val actualFormattedAmount = amount.formatToCurrency(
            currencyFormatter = currencyFormatter
        )

        expectThat(actualFormattedAmount).isEqualTo(fakeFormattedAmount)
    }

}