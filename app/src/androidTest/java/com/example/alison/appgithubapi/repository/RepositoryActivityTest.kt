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
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class RepositoryActivityTest {

//    private lateinit var mockServer: MockWebServer

    @Rule
    @JvmField var mRepositoryActivityRule =
            ActivityTestRule(RepositoryActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareUserLogged()
//        mockServer = MockWebServer()
//        mockServer.start()
        setupServerUrl()
    }

    @After
    fun clearSharedPreferences() {
        val prefsClear = PreferencesUtil(InstrumentationRegistry.getTargetContext())
        prefsClear.clearSP()
    }

    @After
    fun tearDown() {
//        mockServer.shutdown()
    }

    @Test
    fun givenRequest_WhenReturnWebServeOk_ThenShowListRepository() {
//        mockServer.enqueue(MockResponse().setResponseCode(200).setBody(MockListRepository.sucessResponse))
        mRepositoryActivityRule.launchActivity(Intent())
        onView(withId(R.id.rvRepository)).check(matches(isDisplayed()))
    }

    private fun prepareUserLogged() {
        val prefs = PreferencesUtil(InstrumentationRegistry.getTargetContext())
        prefs.setSP("email", "exemplo@exemplo.com")
        prefs.setSP("password", "123")
        prefs.setSP("logged", true)
    }

    private fun setupServerUrl() {
//        val url = mockServer.url("https://api.github.com/").toString()

//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//        val repositoryView = RepositoryActivity()
//        val repositoryDataSource = RepositoryDataSource(RepositoryPresenter(repositoryView))
//
//        val api = Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//                .addConverterFactory(GsonConverterFactory.create())
////                .baseUrl(url)
//                .client(client)
//                .build()
//                .create(GithubApiService::class.java)

//        setField(repositoryDataSource, "api", api)
    }

//    private fun setField(target: Any, fieldName: String, value: Any) {
//        Mirror()
//                .on(target)
//                .set()
//                .field(fieldName)
//                .withValue(value)
//    }
}
