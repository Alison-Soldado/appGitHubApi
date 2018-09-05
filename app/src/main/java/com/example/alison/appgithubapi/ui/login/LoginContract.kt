package com.example.alison.appgithubapi.ui.login

import android.support.annotation.StringRes
import com.example.alison.appgithubapi.BasePresenter
import com.example.alison.appgithubapi.BaseView

interface LoginContract{

    interface View : BaseView<Presenter> {
        fun showProgressBar()
        fun hideProgressBar()
        fun setEmailError(@StringRes errorRes : Int)
        fun setPasswordError(@StringRes errorRes : Int)
        fun showSuccess(@StringRes message : Int)
        fun showUserAndPasswordIncorrect(@StringRes message : Int)
        fun showRepository()
    }

    interface Presenter : BasePresenter {
        fun login(email : String, password : String)
        fun verifyUserLogged()
    }
}