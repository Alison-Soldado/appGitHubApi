package com.example.alison.appgithubapi.pull

import android.content.Intent
import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.widget.TextView
import com.example.alison.appgithubapi.BaseInstrumentedTest
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


const val EMAIL = "exemplo@exemplo.com"
const val PASSWORD = "123"

@RunWith(AndroidJUnit4::class)
@SmallTest
class PullActivityTest : BaseInstrumentedTest() {

    @Rule
    @JvmField var mPullActivityRule =
            ActivityTestRule(PullActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareUserLogged()
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShowNameRepositoryInToolbar() {
        initActivity()
        onView(withId(android.support.design.R.id.action_bar)).check(matches(withText("RxJava")))
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowNumberIssueOpen() {
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowNumberIssueClose() {
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowListPull() {
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowEmptyState() {
    }

    private fun prepareUserLogged() {
        val preferencesUtil = PreferencesUtil(getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun initActivity() {
        mPullActivityRule.launchActivity(Intent())
    }

    private fun requestListPull() {
        serverRule.addFixture(200, "pull/success_list_pull_request.json")
    }

    fun setText(text: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return allOf(isDisplayed(), isAssignableFrom(TextView::class.java))
            }

            override fun getDescription(): String {
                return "Change view text"
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = text
            }
        }
    }
}
