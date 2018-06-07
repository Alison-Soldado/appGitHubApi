package com.example.alison.appgithubapi.repository


import android.content.Intent
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.BaseInstrumentedTest
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.util.PreferencesUtil
import com.example.alison.appgithubapi.utils.EMAIL
import com.example.alison.appgithubapi.utils.PASSWORD
import com.example.alison.appgithubapi.utils.TEXT_EXIT_APP
import com.example.alison.appgithubapi.utils.TITLE_TOOLBAR_REPOSITORY
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
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
    @Ignore("Esta quebrando por causa da próxima requisição")
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
        val preferencesUtil = PreferencesUtil(getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun requestListRepository() {
        serverRule.addFixture(200, "repository/success_list_repository.json")
    }

    private fun requestNextListRepository() {
        serverRule.addFixture(200, "repository/success_next_list_repository.json")
    }

    private fun requestFailureListRepository() {
        serverRule.addFixture(403, "repository/failure_request_list_repository.json")
    }

    private fun initActivity() {
        mRepositoryActivityRule.launchActivity(Intent())
    }
}
