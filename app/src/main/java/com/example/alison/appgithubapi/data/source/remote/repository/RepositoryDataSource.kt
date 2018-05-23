package com.example.alison.appgithubapi.data.source.remote.repository

import com.example.alison.appgithubapi.data.source.DataSource
import com.example.alison.appgithubapi.repository.RepositoryPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

const val PAGE_START = 1

class RepositoryDataSource(private val presenter: RepositoryPresenter): DataSource.RepoDataSource {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var PAGE_NEXT = 2

    override fun requestList() {
        val repository = SearchRepositoryProvider.provideSearchRepository()
        compositeDisposable.add(
                repository.searchRepository(PAGE_START)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe ({
                            result ->
                            presenter.callBackList(result.items)
                        }, { error ->
                            // TODO: Desenvolver cenários de falha na requisição
                            error.printStackTrace()
                        })
        )
    }

    override fun requestNextList() {
        val repository = SearchRepositoryProvider.provideSearchRepository()
        compositeDisposable.add(
                repository.searchRepository(PAGE_NEXT)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe ({
                            result ->
                            presenter.callBackNextList(result.items)
                            PAGE_NEXT++
                        }, { error ->
                            error.printStackTrace()
                        })
        )
    }
}