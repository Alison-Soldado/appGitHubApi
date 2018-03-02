package com.example.alison.appgithubapi.repository

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.requestmatcher.InstrumentedTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import br.com.concretesolutions.requestmatcher.model.HttpMethod
import com.example.alison.appgithubapi.repository.mock.MockListRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class RepositoryActivityTest {

    private lateinit var rootUrl: String

    @Rule
    @JvmField
    val server: RequestMatcherRule = InstrumentedTestRequestMatcherRule()

    @Before
    fun setup() {
        rootUrl = server.url("https://api.github.com/").toString()
    }

    @Test
    fun test() {
        server
                .addFixture(200, MockListRepository.sucessResponse)
                .ifRequestMatches()
                .pathIs(rootUrl + "search/repositories?q=language:Java&sort=stars&page=1")
                .methodIs(HttpMethod.GET)

    }
}