package com.example.alison.appgithubapi.repository

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.BaseInstrumentedTest
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.login.LoginActivity
import com.example.alison.appgithubapi.pull.PullActivity
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class RepositoryActivityTestIntent : BaseInstrumentedTest() {

    @Rule
    @JvmField var mIntentRepository =
            IntentsTestRule(RepositoryActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareUserLogged()
    }

    @Test
    fun givenListRepository_WhenUserClickItem_ThenShootIntentToPull() {
        setupServerRuleRepository()
        requestListRepository()
        initActivity()
        val matcher = hasComponent(PullActivity::class.java.name)
        val activityResult = Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        intending(matcher).respondWith(activityResult)
        onView(withId(R.id.rvRepository)).perform(click())
        intended(matcher)
    }

    @Test
    fun givenLoginCorrect_WhenLoadDisplayRepository_ThenShootIntentToLogin() {
        initActivity()
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        val matcher = hasComponent(LoginActivity::class.java.name)
        val activityResult = Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        intending(matcher).respondWith(activityResult)
        onView(withText(TEXT_EXIT_APP)).perform(click())
        intended(matcher)
    }

    private fun prepareUserLogged() {
        val preferencesUtil = PreferencesUtil(getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun requestListRepository() {
        serverRule.addFixture(200, "success_list_repository.json")
    }

    private fun initActivity() {
        mIntentRepository.launchActivity(Intent())
    }
}