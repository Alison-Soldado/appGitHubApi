package com.example.alison.appgithubapi.repository

import com.example.alison.appgithubapi.BasePresenter
import com.example.alison.appgithubapi.BaseView
import com.example.alison.appgithubapi.data.model.repository.Items

interface RepositoryContract {

    interface View : BaseView<Presenter> {
        fun loadEmailHeader(email : String)
        fun showProgressBar()
        fun hideProgressBar()
        fun showFooter()
        fun hideFooter()
        fun showLogin()
        fun loadList(items : ArrayList<Items>)
        fun updateList(items : ArrayList<Items>)
        fun exitApplication()
    }

    abstract class Presenter : BasePresenter() {
        abstract fun getEmail()
        abstract fun loadListRepository()
        abstract fun loadNextListRepository()
        abstract fun callBackList(items : ArrayList<Items>)
        abstract fun callBackNextList(items : ArrayList<Items>)
        abstract fun verifyUserLogged()
        abstract fun clearSharedPreferencesAndExit()
    }
}