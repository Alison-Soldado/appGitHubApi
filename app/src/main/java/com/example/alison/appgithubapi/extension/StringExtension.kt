package com.example.alison.appgithubapi.extension

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.formatDataToFormatBrazil() : String {
    val formatDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    var enterData: Date? = null
    try {
        enterData = formatDate.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(enterData)
}