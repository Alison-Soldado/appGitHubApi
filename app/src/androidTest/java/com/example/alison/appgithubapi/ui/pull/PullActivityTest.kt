package com.example.alison.appgithubapi.ui.pull

import android.content.Intent
import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.BaseInstrumentedTest
import com.example.alison.appgithubapi.util.PreferencesUtil
import com.example.alison.appgithubapi.utils.EMAIL
import com.example.alison.appgithubapi.utils.PASSWORD
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class PullActivityTest : BaseInstrumentedTest() {

    @Rule
    @JvmField var mPullActivityRule =
            ActivityTestRule(PullActivity::class.java, false, false)

    @Before
    fun setup() {
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShowNameRepositoryInToolbar() {
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

}
