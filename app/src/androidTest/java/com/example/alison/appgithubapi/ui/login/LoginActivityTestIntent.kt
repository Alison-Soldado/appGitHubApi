package com.example.alison.appgithubapi.ui.login

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.MediumTest
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.ui.repository.RepositoryActivity
import com.example.alison.appgithubapi.util.PreferencesUtil
import com.example.alison.appgithubapi.utils.EMAIL
import com.example.alison.appgithubapi.utils.PASSWORD
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTestIntent {

    @Rule
    @JvmField var mIntentLogin =
            IntentsTestRule(LoginActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareLogout()
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailAndPasswordCorrect_ThenShouldShootIntent() {
        initActivity()
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD), closeSoftKeyboard())
        val matcherRepository = hasComponent(RepositoryActivity::class.java.name)
        val activityResultRepository = Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        intending(matcherRepository).respondWith(activityResultRepository)
        onView(withId(R.id.btnEnter)).perform(click())
        intended(matcherRepository)
    }

    private fun initActivity() {
        mIntentLogin.launchActivity(Intent())
    }

    private fun prepareLogout() {
        val preferencesUtil = PreferencesUtil(getTargetContext())
        preferencesUtil.clearSP()
    }
}