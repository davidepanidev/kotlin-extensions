package com.davidepani.kotlinextensions.utils.test

data class TestException(
    override val message: String? = null
) : Exception(message)