package com.example.alison.appgithubapi.pull

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers.toPackage
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.data.model.repository.Items
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test


class PullActivityTestIntent {

    @Rule
    @JvmField var mIntentPull =
            IntentsTestRule(PullActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareUserLogged()
    }

    @Test
    fun givenClickListRepository_WhenLoadDisplayPull_ThenGetIntentFired() {
        prepareIntent()
        initActivity()
    }

    @Test
    @Ignore("Exemplo de teste de intent")
    fun activityResult_DisplaysContactsPhoneNumber() {
        // Build the result to return when the activity is launched.
        val resultData = Intent()
        val phoneNumber = "123-345-6789"
        resultData.putExtra("phone", phoneNumber)
        val result = ActivityResult(Activity.RESULT_OK, resultData)

        // Set up result stubbing when an intent sent to "contacts" is seen.
        intending(toPackage("com.android.contacts")).respondWith(result)

        // User action that results in "contacts" activity being launched.
        // Launching activity expects phoneNumber to be returned and displayed.
        onView(withId(R.id.rvRepository)).perform(click())

        // Assert that the data we set up above is shown.
        onView(withId(R.id.rvRepository)).check(matches(withText(phoneNumber)))
    }

    private fun prepareUserLogged() {
        val preferencesUtil = PreferencesUtil(getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun initActivity() {
        mIntentPull.launchActivity(Intent())
    }

    private fun prepareIntent() {
        val intentItemRepository = Intent()
        val item: Items? = null
        intentItemRepository.putExtra("item", item)
    }
}