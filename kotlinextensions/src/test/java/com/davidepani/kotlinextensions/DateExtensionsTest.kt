package com.davidepani.kotlinextensions

import org.junit.Assert.assertEquals
import org.junit.Test
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

}