package com.example.alison.appgithubapi.pull

import com.example.alison.appgithubapi.data.model.pull.PullRequest
import com.example.alison.appgithubapi.data.source.remote.pull.PullRequestDataSource


class PullPresenter(private val pullView : PullContract.View) : PullContract.Presenter() {

    private lateinit var pullRequestDataSource: PullRequestDataSource

    override fun start() {
        pullView.presenter = this
        pullRequestDataSource = PullRequestDataSource(this)
    }

    override fun loadListPulls(login: String, name: String) {
        pullView.showProgressBar()
        pullRequestDataSource.requestListPull(login, name)
    }

    override fun callBackListPulls(pullRequests: ArrayList<PullRequest>) {
        pullView.hideProgressBar()
        pullView.loadList(pullRequests)
    }
}