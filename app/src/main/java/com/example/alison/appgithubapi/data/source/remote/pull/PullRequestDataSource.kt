package com.example.alison.appgithubapi.data.source.remote.pull

import com.example.alison.appgithubapi.data.source.DataSource
import com.example.alison.appgithubapi.pull.PullPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class PullRequestDataSource (private val presenter: PullPresenter): DataSource.PullDataSource {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun requestListPull(login: String, name: String) {
        val pull = SearchPullRequestProvider.provideSearchPullRequest()
        compositeDisposable.add(
                pull.searchPullRequest(login, name)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ result ->
                            presenter.callBackListPulls(result)
                        }, { error ->
                            // TODO: Desenvolver cenários de falha na requisição
                            error.printStackTrace()
                        })
        )
    }
}