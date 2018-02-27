package com.example.alison.appgithubapi.data.source.remote.repository

import com.example.alison.appgithubapi.data.source.remote.GithubApiService

object SearchRepositoryProvider {

    fun provideSearchRepository() = SearchRepository(GithubApiService.create())
}