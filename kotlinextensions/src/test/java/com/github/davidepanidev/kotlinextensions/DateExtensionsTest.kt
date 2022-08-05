package com.github.davidepanidev.kotlinextensions

import org.junit.Assert.assertEquals
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.time.temporal.ChronoUnit
import java.util.*

class DateExtensionsTest {

    @Test
    fun `toFormattedString yyyy-MM-dd format`() {
        val date = Date(1648197341133)
        val actualFormattedDate = date.toFormattedString("yyyy-MM-dd")
        val expectedFormattedDate = "2022-03-25"

        assertEquals(expectedFormattedDate, actualFormattedDate)
    }

    @Test
    fun `toFormattedString dd MM yyyy format`() {
        val date = Date(1648197341133)
        val actualFormattedDate = date.toFormattedString("dd/MM/yyyy")
        val expectedFormattedDate = "25/03/2022"

        assertEquals(expectedFormattedDate, actualFormattedDate)
    }


    @Test
    fun `toFormattedString returns localized SHORT formatted String`() {
        val date = LocalDateTime.of(2022, 12, 12, 12, 12)
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.ITALIAN)
        val actualFormattedDate = date.toFormattedString(formatter)
        val expectedFormattedDate = "12/12/22, 12:12"

        assertEquals(expectedFormattedDate, actualFormattedDate)
    }

    @Test
    fun `toFormattedDateWithTimeString returns localized SHORT formatted String`() {
        val date = LocalDateTime.of(2022, 12, 12, 12, 12)
        val actualFormattedDate = date.toFormattedDateWithTimeString(
            formatStyle = FormatStyle.SHORT,
            locale = Locale.ITALIAN
        )
        val expectedFormattedDate = "12/12/22, 12:12"

        assertEquals(expectedFormattedDate, actualFormattedDate)
    }

    @Test
    fun `toFormattedDateString returns localized SHORT formatted String`() {
        val date = LocalDateTime.of(2022, 12, 12, 12, 12)
        val actualFormattedDate = date.toFormattedDateString(
            formatStyle = FormatStyle.SHORT,
            locale = Locale.ITALIAN
        )
        val expectedFormattedDate = "12/12/22"

        assertEquals(expectedFormattedDate, actualFormattedDate)
    }

    @Test
    fun `toFormattedDateOnlyString returns localized SHORT formatted String`() {
        val date = LocalDateTime.of(2022, 12, 12, 12, 12)
        val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.ITALIAN)
        val actualFormattedDate = date.toFormattedDateOnlyString(formatter)
        val expectedFormattedDate = "12/12/22"

        assertEquals(expectedFormattedDate, actualFormattedDate)
    }

    @Test
    fun `minutesBetween returns correct minutes difference`() {
        val date = LocalDateTime.of(2022, 12, 12, 12, 12)
        val date2 = LocalDateTime.of(2022, 12, 12, 12, 9)
        val expectedDifferenceValue = -3L
        val actualDifferenceValue = date.minutesBetween(date2)

        expectThat(actualDifferenceValue).isEqualTo(expectedDifferenceValue)
    }

    @Test
    fun `differenceBetween returns correct days difference`() {
        val date = LocalDateTime.of(2022, 12, 12, 12, 12)
        val date2 = LocalDateTime.of(2022, 12, 12, 12, 9)
        val expectedDifferenceValue = 0L
        val actualDifferenceValue = date.differenceBetween(date2, ChronoUnit.DAYS)

        expectThat(actualDifferenceValue).isEqualTo(expectedDifferenceValue)
    }

    @Test
    fun `differenceBetween returns correct years difference`() {
        val date = LocalDateTime.of(2021, 12, 12, 12, 9)
        val date2 = LocalDateTime.of(2022, 12, 12, 12, 9)
        val expectedDifferenceValue = 1L
        val actualDifferenceValue = date.differenceBetween(date2, ChronoUnit.YEARS)

        expectThat(actualDifferenceValue).isEqualTo(expectedDifferenceValue)
    }

}