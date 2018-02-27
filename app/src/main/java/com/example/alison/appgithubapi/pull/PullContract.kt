package com.example.alison.appgithubapi.pull

import com.example.alison.appgithubapi.BasePresenter
import com.example.alison.appgithubapi.BaseView
import com.example.alison.appgithubapi.data.model.pull.PullRequest

interface PullContract {

    interface View : BaseView<Presenter> {
        fun showProgressBar()
        fun hideProgressBar()
        fun loadList(pullRequests : ArrayList<PullRequest>)
    }

    interface Presenter : BasePresenter {
        fun loadListPulls(login: String, name: String)
        fun callBackListPulls(pullRequests : ArrayList<PullRequest>)
    }
}