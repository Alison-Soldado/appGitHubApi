package com.example.alison.appgithubapi.repository


import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.BaseInstrumentedTest
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

const val EMAIL = "exemplo@exemplo.com"
const val PASSWORD = "123"
const val TITLE_TOOLBAR_REPOSITORY = "Repository"
const val TEXT_EXIT_APP = "Sair"

@RunWith(AndroidJUnit4::class)
@SmallTest
class RepositoryActivityTest : BaseInstrumentedTest() {

    @Rule
    @JvmField var mRepositoryActivityRule =
            ActivityTestRule(RepositoryActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareUserLogged()
    }

    @Test
    fun givenLoginCorrect_WhenDisplayRepository_ThenShowToolbar() {
        initActivity()
        onView(withId(R.id.toolbarRepository)).check(matches(isDisplayed()))
    }

    @Test
    fun givenLoginCorrect_WhenLoadDisplayRepository_ThenShowTextInToolbar() {
        initActivity()
        onView(withText(TITLE_TOOLBAR_REPOSITORY)).check(matches(withParent(withId(R.id.toolbarRepository))))
    }

    @Test
    fun givenLoginCorrect_WhenLoadDisplayRepository_ThenShowIconSearch() {
        initActivity()
        onView(withId(R.id.searchRepository)).check(matches(isDisplayed()))
    }

    @Test
    fun givenLoginCorrect_WhenLoadDisplayRepository_ThenShowMenu() {
        initActivity()
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(TEXT_EXIT_APP)).check(matches(isDisplayed()))
    }

    @Test
    fun givenLoginCorrect_WhenLoadDisplayRepository_ThenShowEmailHeader() {
        initActivity()
        onView(withId(R.id.txtWelcome)).check(matches(withText(EMAIL)))
    }

    @Test
    fun givenLoginCorrect_WhenRequestSuccess_ThenShowListRepository() {
        setupServerRuleRepository()
        requestListRepository()
        initActivity()
        onView(withId(R.id.rvRepository)).check(matches(isDisplayed()))
    }

    @Test
    fun givenScrollToDown_WhenRequestNextList_ThenShowNextListRepository() {
        setupServerRuleRepository()
        requestListRepository()
        initActivity()
        onView(withId(R.id.rvRepository)).perform(scrollToPosition<RepositoryAdapter.MainViewHolder>(10))
    }

    @Test
    fun givenScrollToDown_WhenRequestNextList_ThenShowProgressFooter() {
        setupServerRuleRepository()
        requestListRepository()
        requestNextListRepository()
        initActivity()
        onView(withId(R.id.rvRepository)).perform(swipeUp(), swipeUp())
        onView(withId(R.id.linearFooter)).check(matches(isDisplayed()))
    }

    @Test
    fun givenLoginCorrect_WhenRequestFailure_ThenShouldShowEmptyState() {
        setupServerRuleRepository()
        requestFailureListRepository()
        initActivity()
    }

    private fun prepareUserLogged() {
        val preferencesUtil = PreferencesUtil(InstrumentationRegistry.getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun requestListRepository() {
        serverRule.addFixture(200, "success_list_repository.json")
    }

    private fun requestNextListRepository() {
        serverRule.addFixture(200, "success_next_list_repository.json")
    }

    private fun requestFailureListRepository() {
        serverRule.addFixture(403, "failure_request_list_repository.json")
    }

    private fun initActivity() {
        mRepositoryActivityRule.launchActivity(Intent())
    }
}
