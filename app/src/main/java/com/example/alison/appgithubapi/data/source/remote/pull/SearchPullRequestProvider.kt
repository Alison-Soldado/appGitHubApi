package com.example.alison.appgithubapi.data.source.remote.pull

import com.example.alison.appgithubapi.data.source.remote.GithubApiService

object SearchPullRequestProvider {

    var searchPull = SearchPullRequest(GithubApiService.create())
    fun provideSearchPullRequest() = searchPull
}