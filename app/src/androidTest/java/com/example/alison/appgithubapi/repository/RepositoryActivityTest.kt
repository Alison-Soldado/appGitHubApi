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
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


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
        scrollToBelow()
        verifyIfShowNextList()
    }

    @Test
    fun givenRequestNextList_WhenUserFinalPreviousList_ThenShowFooterBelow() {
        prepareUserLogged()
        initActivity()
        scrollToBelow()
        verifyIfShowFooter()
    }

    @Test
    fun givenListRepository_WhenUserClickItem_ThenShootIntentToPull() {
        prepareUserLogged()
        initActivity()
        clickItemVerifyIntentShoot()
    }

    private fun clickItemVerifyIntentShoot() {

    }

    private fun verifyIfShowEmailHeader() {

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

    private fun scrollToBelow() {

    }

    private fun verifyIfShowFooter() {

    }
}
