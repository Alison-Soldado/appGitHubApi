package com.example.alison.appgithubapi.ui.login

import android.content.Intent
import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.util.PreferencesUtil
import com.example.alison.appgithubapi.utils.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField var mLoginActivityRule =
            ActivityTestRule(LoginActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareLogout()
    }

    @Test
    fun givenClickInIcon_WhenLoadDisplay_ThenShouldShowComponents() {
        initActivity()
        onView(withId(R.id.edtEmailLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.edtPasswordLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.btnEnter)).check(matches(isDisplayed()))
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailEmpty_ThenShouldSetError() {
        initActivity()
        onView(withId(R.id.edtEmailLogin)).perform(clearText())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD), closeSoftKeyboard())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withId(R.id.edtEmailLogin)).check(matches(hasErrorText(MESSAGE_ERROR_EMAIL)))
    }

    @Test
    fun givenClickOnLoginButton_WhenPasswordEmpty_ThenShouldSetError() {
        initActivity()
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(clearText())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withId(R.id.edtPasswordLogin)).check(matches(hasErrorText(MESSAGE_ERROR_PASSWORD)))
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailError_ThenShouldShowMessageEmailInvalid() {
        initActivity()
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL_ERROR), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD), closeSoftKeyboard())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withId(R.id.edtEmailLogin)).check(matches(hasErrorText(MESSAGE_INVALID_EMAIL)))
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailAndPasswordIncorrect_ThenShouldShowMessageIncorrect() {
        initActivity()
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL_INCORRECT), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD_INCORRECT), closeSoftKeyboard())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withText(MESSAGE_INCORRECT))
                .inRoot(withDecorView(not(`is`(mLoginActivityRule.activity.window.decorView))))
                .check(matches(isDisplayed()))
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailAndPasswordCorrect_ThenShowMessageWelcome() {
        initActivity()
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD), closeSoftKeyboard())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withText(MESSAGE_WELCOME))
                .inRoot(withDecorView(not(`is`(mLoginActivityRule.activity.window.decorView))))
                .check(matches(isDisplayed()))
    }

    private fun prepareLogout() {
        val preferencesUtil = PreferencesUtil(getTargetContext())
        preferencesUtil.clearSP()
    }

    private fun initActivity() {
        mLoginActivityRule.launchActivity(Intent())
    }
}
