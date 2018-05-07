package com.example.alison.appgithubapi.data.source.remote.repository

import com.example.alison.appgithubapi.App
import com.example.alison.appgithubapi.data.model.repository.Result
import com.example.alison.appgithubapi.data.source.CallbackRequest
import com.example.alison.appgithubapi.data.source.WebServiceImpl
import com.example.alison.appgithubapi.data.source.remote.BaseRepository
import com.example.alison.appgithubapi.repository.RepositoryPresenter
import retrofit2.Response

const val PAGE_START = 1

class RepositoryDataSource(private val presenter: RepositoryPresenter): BaseRepository(presenter) {

    private var PAGE_NEXT = 2

    fun requestList() {
        call {
            WebServiceImpl.getInstance(App.instance).instance.getRepositoryRequest(PAGE_START)
                    .enqueue(object : CallbackRequest<Result>() {
                        override fun success(response: Result) {
                            presenter.callBackList(response.items)
                        }

                        override fun failureHttp(response: Response<Result>) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun failure(throwable: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })
        }
    }

    fun requestNextList() {
        call {
            WebServiceImpl.getInstance(App.instance).instance.getRepositoryRequest(PAGE_NEXT)
                    .enqueue(object : CallbackRequest<Result>() {
                        override fun success(response: Result) {
                            presenter.callBackList(response.items)
                            PAGE_NEXT++
                        }

                        override fun failureHttp(response: Response<Result>) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun failure(throwable: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })
        }
    }
}