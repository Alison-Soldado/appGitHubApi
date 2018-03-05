package com.example.alison.appgithubapi.repository

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.data.source.remote.GithubApiService
import com.example.alison.appgithubapi.data.source.remote.repository.RepositoryDataSource
import com.example.alison.appgithubapi.repository.mock.MockListRepository
import com.example.alison.appgithubapi.util.PreferencesUtil
import io.reactivex.schedulers.Schedulers
import net.vidageek.mirror.dsl.Mirror
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


@RunWith(AndroidJUnit4::class)
@SmallTest
class RepositoryActivityTest {

    private var server = MockWebServer()

    companion object {
        const val EMAIL = "exemplo@exemplo.com"
        const val PASSWORD = "123"
    }

    @Rule
    @JvmField var mRepositoryActivityRule =
            ActivityTestRule(RepositoryActivity::class.java, false, false)

    @Before
    @Throws(Exception::class)
    fun setup() {
        server.start()
        setupServerUrl()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun givenEmailAndPasswordCorrect_WhenClickButtonLogin_ThenShowListRepositoryTest() {
        prepareUserLogged()
        mockListRepository()
        initActivity()
        verifyIfShowList()
    }

    private fun prepareUserLogged() {
        val preferencesUtil = PreferencesUtil(InstrumentationRegistry.getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun mockListRepository() {
        server.enqueue(MockResponse().setResponseCode(200).setBody(MockListRepository.sucessResponse))
    }

    private fun initActivity() {
        mRepositoryActivityRule.launchActivity(Intent())
    }

    private fun verifyIfShowList() {
        onView(withId(R.id.rvRepository)).check(matches(isDisplayed()))
    }

    private fun setupServerUrl() {
        val url = server.url("/").toString()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val search = RepositoryDataSource(RepositoryPresenter(mRepositoryActivityRule.activity))

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .client(client)
                .build()
                .create(GithubApiService::class.java)

        setField(search, "search", retrofit)
    }

    private fun setField(target: Any, fieldName: String, value: Any) {
        Mirror()
                .on(target)
                .set()
                .field(fieldName)
                .withValue(value)
    }
}
