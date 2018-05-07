package com.example.alison.appgithubapi.data.source

import android.content.Context
import com.example.alison.appgithubapi.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by alissonsoldado on 20/04/18.
 */
class WebServiceImpl private constructor(context: Context) {

    private var okHttp = OkHttpImpl.getInstance(context)

    val instance: WebServiceApi
        get() = webServiceApi

    init {
        webServiceApi = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.okHttpClient)
                .build().create(WebServiceApi::class.java)
    }

    companion object {
        lateinit var webServiceApi: WebServiceApi

        @Volatile private var INSTANCE: WebServiceImpl? = null

        fun getInstance(context: Context): WebServiceImpl =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: WebServiceImpl(context).also { INSTANCE = it }
                }
    }
}
