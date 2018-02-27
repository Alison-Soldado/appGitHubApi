package com.example.alison.appgithubapi.extension

import android.widget.TextView

fun TextView.setErrorAndFocus(errorRes: Int) {
    error = context.getString(errorRes)
    requestFocus()
}