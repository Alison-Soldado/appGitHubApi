package com.example.alison.appgithubapi.data.source.remote

import com.example.alison.appgithubapi.BasePresenter
import com.example.alison.appgithubapi.data.source.CallApi


open class BaseRepository(private val presenter: BasePresenter) {
    protected lateinit var executor: CallApi

    protected fun call(block: () -> Unit) {
        executor = object : CallApi {
            override fun execute() {
                block()
            }
        }
        executeCall()
    }

    private fun executeCall() {
        presenter.storageCall(executor)
        executor.execute()
    }

}