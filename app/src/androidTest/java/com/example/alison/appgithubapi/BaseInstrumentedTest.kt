package com.example.alison.appgithubapi

import android.content.Context
import android.support.test.InstrumentationRegistry
import br.com.concretesolutions.requestmatcher.InstrumentedTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import com.example.alison.appgithubapi.data.source.remote.GithubApiService
import com.example.alison.appgithubapi.data.source.remote.repository.RepositoryDataSource
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by alissonsoldado on 20/04/18.
 */
class BaseInstrumentedTest {
    private val DEFAULT_MILLIS: Long = 500

    @Rule
    val serverRule: RequestMatcherRule = InstrumentedTestRequestMatcherRule()

    @Before
    fun beforeBaseRequest() {
        val url = serverRule.url("/").toString()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val api = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                        .create()))
                .client(client)
                .build()
                .create<GithubApiService>(GithubApiService::class.java!!)

        RepositoryDataSource.Companion.getInstance(InstrumentationRegistry.getTargetContext()).webServiceApi = api
    }

    protected fun getApplicationContext(): Context {
        return InstrumentationRegistry.getTargetContext().applicationContext
    }

    protected fun readAssetFile(file: String): String {
        var bytesArray = ByteArray(0)
        try {
            val in_s = InstrumentationRegistry.getContext().assets.open(file)

            bytesArray = ByteArray(in_s.available())
            in_s.read(bytesArray)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return String(bytesArray)
    }

    protected fun doWait() {
        doWait(DEFAULT_MILLIS)
    }

    protected fun doWait(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: Exception) {
            Assert.fail("Could not sleep in test!")
        }

    }

    protected fun enqueueHealthCheck() {
        serverRule.addResponse(MockResponse().setResponseCode(200))
    }
}