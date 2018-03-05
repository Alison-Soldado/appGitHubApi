package com.example.alison.appgithubapi.login

import android.app.Activity
import android.app.Instrumentation
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
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class LoginActivityTestIntent {

    companion object {
        const val EMAIL = "exemplo@exemplo.com"
        const val PASSWORD = "123"
    }

    @get:Rule
    var mIntentRule =
            IntentsTestRule(LoginActivity::class.java, false, true)

    @Test
    fun givenEmailAndPasswordCorrect_WhenClickOnLoginButton_ThenShouldShootIntent() {
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD), closeSoftKeyboard())
        val matcher = hasComponent(RepositoryActivity::class.java.name)
        val activityResult = Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        intending(matcher).respondWith(activityResult)
        onView(withId(R.id.btnEnter)).perform(click())
        intended(matcher)
    }

}