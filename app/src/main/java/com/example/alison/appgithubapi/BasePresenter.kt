package com.example.alison.appgithubapi

import com.example.alison.appgithubapi.data.source.CallApi

abstract class BasePresenter {
    private lateinit var callApi: CallApi
    abstract fun start()
    fun storageCall(callApi: CallApi){ this.callApi = callApi}
    fun retry(){ callApi.execute() }
}