package com.example.alison.appgithubapi.ui.repository

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

    interface Presenter : BasePresenter {
        fun getEmail()
        fun loadListRepository()
        fun loadNextListRepository()
        fun callBackList(items : ArrayList<Items>)
        fun callBackNextList(items : ArrayList<Items>)
        fun verifyUserLogged()
        fun clearSharedPreferencesAndExit()
    }
}