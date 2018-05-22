package com.example.alison.appgithubapi

import android.content.Context
import android.support.test.InstrumentationRegistry
import br.com.concretesolutions.requestmatcher.InstrumentedTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import com.example.alison.appgithubapi.data.source.remote.GithubApiService
import com.example.alison.appgithubapi.data.source.remote.repository.RepositoryDataSource
import com.example.alison.appgithubapi.data.source.remote.repository.SearchRepository
import com.example.alison.appgithubapi.data.source.remote.repository.SearchRepositoryProvider
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val DEFAULT_MILLIS: Long = 500

open class BaseInstrumentedTest {

    @Rule
    @JvmField
    val serverRule: RequestMatcherRule = InstrumentedTestRequestMatcherRule()

    protected fun setupServerRule() {
        val url = serverRule.url("/").toString()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val api = Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(GithubApiService::class.java)

        SearchRepositoryProvider.searchRepository = SearchRepository(api)
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
}