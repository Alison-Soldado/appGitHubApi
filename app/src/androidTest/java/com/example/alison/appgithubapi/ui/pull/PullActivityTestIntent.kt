package com.example.alison.appgithubapi.ui.pull

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.support.test.InstrumentationRegistry.getTargetContext
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers.toPackage
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.filters.MediumTest
import android.support.test.runner.AndroidJUnit4
import com.example.alison.appgithubapi.data.model.repository.Items
import com.example.alison.appgithubapi.data.model.repository.Owner
import com.example.alison.appgithubapi.util.PreferencesUtil
import com.example.alison.appgithubapi.utils.EMAIL
import com.example.alison.appgithubapi.utils.PASSWORD
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class PullActivityTestIntent {

    private lateinit var item : Items

    @Rule
    @JvmField var mIntentPull =
            IntentsTestRule(PullActivity::class.java, false, false)

    @Before
    fun setup() {
        prepareUserLogged()
        initActivity()

    }

    @Test
    fun givenClickListRepository_WhenLoadDisplayPull_ThenGetIntentFired() {
        prepareIntent()
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
        fillItem()
        val intentItemRepository = Intent()
        intentItemRepository.putExtra("item", item)
        val result = ActivityResult(Activity.RESULT_OK, intentItemRepository)
        intending(toPackage(PullActivity::getPackageName::class.java.name)).respondWith(result)
    }

    private fun fillItem() {
        item = Items(1, "Alison", "Alison Soldado", Owner(1, "alison", "xzcc", "zxcc", "zxc"), "zxcz", "uhul", 5446, 5445, 54456)
    }
}