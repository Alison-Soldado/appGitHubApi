package com.example.alison.appgithubapi.data.source

import android.content.Context
import com.example.alison.appgithubapi.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by alissonsoldado on 20/04/18.
 */
class OkHttpImpl private constructor(val context: Context ) {
    lateinit var okHttpClient: OkHttpClient

    init {
        afterInject()
    }

    fun afterInject() {
        val builder = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE))
        okHttpClient = builder.build()
    }

    companion object {
        @Volatile private var INSTANCE: OkHttpImpl? = null
        fun getInstance(context: Context): OkHttpImpl =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: OkHttpImpl(context).also { INSTANCE = it }
                }
    }
}