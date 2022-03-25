package com.davidepani.kotlinextensions

import java.text.SimpleDateFormat
import java.util.*


fun Date.toFormattedString(pattern: String): String {
    return SimpleDateFormat(pattern, Locale.getDefault()).format(this)
}