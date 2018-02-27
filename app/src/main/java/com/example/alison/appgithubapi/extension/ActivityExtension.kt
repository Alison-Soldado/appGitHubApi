package com.example.alison.appgithubapi.extension

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, duration).show()
}