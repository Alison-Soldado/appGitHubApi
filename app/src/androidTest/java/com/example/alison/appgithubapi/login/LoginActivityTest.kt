package com.example.alison.appgithubapi.login

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

const val EMAIL = "exemplo@exemplo.com"
const val PASSWORD = "123"
const val EMAIL_INCORRECT = "teste@teste.com"
const val PASSWORD_INCORRECT = "456"
const val EMAIL_ERROR = "email error"
const val MESSAGE_WELCOME = "Bem Vindo!!!"
const val MESSAGE_ERROR_EMAIL = "Preencha o campo usuário corretamente."
const val MESSAGE_ERROR_PASSWORD = "Preencha o campo senha corretamente."
const val MESSAGE_INVALID_EMAIL = "Digite um e-mail válido."
const val MESSAGE_INCORRECT = "Usuário ou senha incorretos."

@RunWith(AndroidJUnit4::class)
@SmallTest
class LoginActivityTest {

    @Rule
    @JvmField var mLoginActivityRule =
            ActivityTestRule(LoginActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareLogout()
        mLoginActivityRule.launchActivity(Intent())
    }

    @Test
    fun givenClickInIcon_WhenLoadDisplay_ThenShouldShowComponents() {
        onView(withId(R.id.edtEmailLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.edtPasswordLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.btnEnter)).check(matches(isDisplayed()))
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailEmpty_ThenShouldSetError() {
        onView(withId(R.id.edtEmailLogin)).perform(clearText())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD), closeSoftKeyboard())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withId(R.id.edtEmailLogin)).check(matches(hasErrorText(MESSAGE_ERROR_EMAIL)))
    }

    @Test
    fun givenClickOnLoginButton_WhenPasswordEmpty_ThenShouldSetError() {
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(clearText())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withId(R.id.edtPasswordLogin)).check(matches(hasErrorText(MESSAGE_ERROR_PASSWORD)))
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailError_ThenShouldShowMessageEmailInvalid() {
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL_ERROR), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD), closeSoftKeyboard())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withId(R.id.edtEmailLogin)).check(matches(hasErrorText(MESSAGE_INVALID_EMAIL)))
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailAndPasswordIncorrect_ThenShouldShowMessageIncorrect() {
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL_INCORRECT), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD_INCORRECT), closeSoftKeyboard())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withText(MESSAGE_INCORRECT))
                .inRoot(withDecorView(not(`is`(mLoginActivityRule.activity.window.decorView))))
                .check(matches(isDisplayed()))
    }

    @Test
    fun givenClickOnLoginButton_WhenEmailAndPasswordCorrect_ThenShowMessageWelcome() {
        onView(withId(R.id.edtEmailLogin)).perform(typeText(EMAIL), closeSoftKeyboard())
        onView(withId(R.id.edtPasswordLogin)).perform(typeText(PASSWORD), closeSoftKeyboard())
        onView(withId(R.id.btnEnter)).perform(click())
        onView(withText(MESSAGE_WELCOME))
                .inRoot(withDecorView(not(`is`(mLoginActivityRule.activity.window.decorView))))
                .check(matches(isDisplayed()))
    }

    private fun prepareLogout() {
        val preferencesUtil = PreferencesUtil(InstrumentationRegistry.getTargetContext())
        preferencesUtil.clearSP()
    }
}
