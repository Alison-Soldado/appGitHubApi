package com.example.alison.appgithubapi.data.source.remote.repository

import com.example.alison.appgithubapi.data.source.remote.GithubApiService

class SearchRepository(private val apiService: GithubApiService) {

    fun searchRepository(page: Int) = apiService.search(page)
}