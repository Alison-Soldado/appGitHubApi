package com.example.alison.appgithubapi.pull

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.repository.RepositoryActivityTest
import com.example.alison.appgithubapi.util.PreferencesUtil
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class PullActivityTest {

    @Rule
    @JvmField var mPullActivityRule =
            ActivityTestRule(PullActivity::class.java, false, false)

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowNameRepositoryInToolbar() {

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
        val preferencesUtil = PreferencesUtil(InstrumentationRegistry.getTargetContext())
        preferencesUtil.setSP("email", RepositoryActivityTest.EMAIL)
        preferencesUtil.setSP("password", RepositoryActivityTest.PASSWORD)
    }

    private fun initActivity() {
        mPullActivityRule.launchActivity(Intent())
    }
}