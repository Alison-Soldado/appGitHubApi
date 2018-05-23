package com.example.alison.appgithubapi.login

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
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.repository.RepositoryActivity
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
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
        val matcher = hasComponent(RepositoryActivity::class.java.name)
        val activityResult = Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        intending(matcher).respondWith(activityResult)
        onView(withId(R.id.btnEnter)).perform(click())
        intended(matcher)
    }

    private fun initActivity() {
        mIntentLogin.launchActivity(Intent())
    }

    private fun prepareLogout() {
        val preferencesUtil = PreferencesUtil(getTargetContext())
        preferencesUtil.clearSP()
    }
}