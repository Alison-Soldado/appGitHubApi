package com.example.alison.appgithubapi.repository

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import br.com.concretesolutions.requestmatcher.LocalTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import br.com.concretesolutions.requestmatcher.model.HttpMethod
import com.example.alison.appgithubapi.data.model.repository.Items
import com.google.gson.Gson


@RunWith(AndroidJUnit4::class)
@SmallTest
class RepositoryActivityTest {

    companion object {
        const val EMAIL = "exemplo@exemplo.com"
        const val PASSWORD = "123"
    }

    @Rule
    @JvmField var mRepositoryActivityRule =
            ActivityTestRule(RepositoryActivity::class.java, false, false)

    @Rule
    val serverRule: RequestMatcherRule = LocalTestRequestMatcherRule()

    @Before
    fun setup(){
        val rootUrl = serverRule.url("/")
    }

    @Test
    fun givenEmailAndPasswordCorrect_WhenClickButtonLogin_ThenShowEmailInHeader() {
        prepareUserLogged()
        initActivity()
        verifyIfShowEmailHeader()
    }

    @Test
    fun givenEmailAndPasswordCorrect_WhenClickButtonLogin_ThenShowListRepositoryTest() {
        prepareUserLogged()
        initActivity()
        verifyIfShowList()
    }

    @Test
    fun givenListRepository_WhenRequestNextList_ThenShowNextListRepository() {
        prepareUserLogged()
        initActivity()
        verifyIfShowNextList()
    }

    @Test
    fun givenRequestNextList_WhenUserFinalPreviousList_ThenShowFooterBelow() {
        prepareUserLogged()
        initActivity()
        verifyIfShowFooter()
    }

    @Test
    fun givenListRepository_WhenUserClickItem_ThenShootIntentToPull() {
        prepareUserLogged()
        initActivity()
        clickItemVerifyIntentShoot()
    }

    @Test
    fun givenRequestList_WhenClickButtonLogin_ThenShouldShowEmptyState() {

    }

    private fun clickItemVerifyIntentShoot() {
    }

    private fun verifyIfShowEmailHeader() {
        onView(withText(EMAIL)).check(matches(isDisplayed()))
    }

    private fun prepareUserLogged() {
        val preferencesUtil = PreferencesUtil(InstrumentationRegistry.getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun initActivity() {
        mRepositoryActivityRule.launchActivity(Intent())
    }

    private fun verifyIfShowList() {
        onView(withId(R.id.rvRepository)).check(matches(isDisplayed()))
    }

    private fun verifyIfShowNextList() {

    }

    private fun verifyIfShowFooter() {
        onView(withId(R.id.linearFooter)).perform(scrollTo()).check(matches(isDisplayed()))
    }

    private fun prepareMockListRepository(){
        val items = Gson().fromJson(readAssetFile("fixtures/success_list_repository.json"), Items::class.java)
    }

    private fun readAssetFile(file: String): String {
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
}
