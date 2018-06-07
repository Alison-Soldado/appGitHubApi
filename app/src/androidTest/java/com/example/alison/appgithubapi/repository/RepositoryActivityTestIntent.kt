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
import android.support.test.filters.MediumTest
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.BaseInstrumentedTest
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.data.model.repository.Items
import com.example.alison.appgithubapi.login.LoginActivity
import com.example.alison.appgithubapi.pull.PullActivity
import com.example.alison.appgithubapi.util.PreferencesUtil
import com.example.alison.appgithubapi.utils.EMAIL
import com.example.alison.appgithubapi.utils.PASSWORD
import com.example.alison.appgithubapi.utils.TEXT_EXIT_APP
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
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
        val matcherPull = hasComponent(PullActivity::class.java.name)
        val activityResultPull = Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        intending(matcherPull).respondWith(activityResultPull)
        onView(withId(R.id.rvRepository)).perform(click())
        intended(matcherPull)
    }

    @Test
    fun givenListRepository_WhenUserClickItem_ThenShootIntentToPullWithItem() {
        setupServerRuleRepository()
        requestListRepository()
        initActivity()
        val intentItemRepository = Intent()
        val item: Items? = null
        intentItemRepository.putExtra("item", item)
        val matcherPull = hasComponent(PullActivity::class.java.name)
        val activityResultPull = Instrumentation.ActivityResult(Activity.RESULT_OK, intentItemRepository)
        intending(matcherPull).respondWith(activityResultPull)
        onView(withId(R.id.rvRepository)).perform(click())
        intended(matcherPull)
    }

    @Test
    fun givenLoginCorrect_WhenLoadDisplayRepository_ThenShootIntentToLogin() {
        initActivity()
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        val matcherLogin = hasComponent(LoginActivity::class.java.name)
        val activityResultLogin = Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        intending(matcherLogin).respondWith(activityResultLogin)
        onView(withText(TEXT_EXIT_APP)).perform(click())
        intended(matcherLogin)
    }

    private fun prepareUserLogged() {
        val preferencesUtil = PreferencesUtil(getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun requestListRepository() {
        serverRule.addFixture(200, "repository/success_list_repository.json")
    }

    private fun initActivity() {
        mIntentRepository.launchActivity(Intent())
    }
}