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

const val EMAIL = "exemplo@exemplo.com"
const val PASSWORD = "123"

@RunWith(AndroidJUnit4::class)
@SmallTest
class PullActivityTest {

    @Rule
    @JvmField var mPullActivityRule =
            ActivityTestRule(PullActivity::class.java, false, false)

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowNameRepositoryInToolbar() {
        prepareUserLogged()
        initActivity()
        verifyNameToolbar()
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowNumberIssueOpen() {
        prepareUserLogged()
        initActivity()
        verifyShowNumberIssueOpen()
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowNumberIssueClose() {
        prepareUserLogged()
        initActivity()
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowListPull() {
        prepareUserLogged()
        initActivity()
    }

    @Test
    fun givenClickItemListRepository_WhenUserRedirectToPull_ThenShouldShowEmptyState() {
        prepareUserLogged()
        initActivity()
    }

    private fun verifyNameToolbar() {

    }

    private fun verifyShowNumberIssueOpen() {

    }


    private fun prepareUserLogged() {
        val preferencesUtil = PreferencesUtil(InstrumentationRegistry.getTargetContext())
        preferencesUtil.setSP("email", EMAIL)
        preferencesUtil.setSP("password", PASSWORD)
    }

    private fun initActivity() {
        mPullActivityRule.launchActivity(Intent())
    }
}
