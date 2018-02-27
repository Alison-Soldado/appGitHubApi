package com.example.alison.appgithubapi

import android.app.Application

class App : Application() {

    companion object {
        lateinit var instance : App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}