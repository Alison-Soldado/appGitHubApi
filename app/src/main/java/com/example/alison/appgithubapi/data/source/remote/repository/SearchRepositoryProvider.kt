package com.example.alison.appgithubapi.data.source.remote.repository

import com.example.alison.appgithubapi.data.source.remote.GithubApiService

object SearchRepositoryProvider {

    var searchRepository =  SearchRepository(GithubApiService.create())
    fun provideSearchRepository() = searchRepository
}