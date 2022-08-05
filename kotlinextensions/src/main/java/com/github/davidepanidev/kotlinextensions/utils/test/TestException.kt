package com.github.davidepanidev.kotlinextensions.utils.test

data class TestException(
    override val message: String? = null
) : Exception(message)