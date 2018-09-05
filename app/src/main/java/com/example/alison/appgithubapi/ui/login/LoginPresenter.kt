package com.example.alison.appgithubapi.ui.login

import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.data.source.local.UserDataSourceSP


class LoginPresenter (private val loginView : LoginContract.View) : LoginContract.Presenter {

    private lateinit var userDataSourceSP : UserDataSourceSP

    override fun start() {
        loginView.presenter = this
        userDataSourceSP = UserDataSourceSP()
    }

    override fun login(email : String, password: String) {
        loginView.showProgressBar()
        when {
            email.isEmpty() -> {
                loginView.hideProgressBar()
                loginView.setEmailError(R.string.msgErrorEmail)
            }
            password.isEmpty() -> {
                loginView.hideProgressBar()
                loginView.setPasswordError(R.string.msgErrorPassword)
            }
            !isEmailValid(email) -> {
                loginView.hideProgressBar()
                loginView.setEmailError(R.string.msgErrorEmailValid)
            }
            email != "exemplo@exemplo.com" || password != "123" -> {
                loginView.hideProgressBar()
                loginView.showUserAndPasswordIncorrect(R.string.msgErrorEmailPass)
            }
            else -> {
                if (userDataSourceSP.setUser(email, password)){
                    loginView.hideProgressBar()
                    loginView.showSuccess(R.string.welcome)
                    loginView.showRepository()
                }
            }
        }
    }

    override fun verifyUserLogged() {
        if (userDataSourceSP.getUser().logged) {
            loginView.showRepository()
        }
    }

    private fun isEmailValid(email : String) = email.contains("@")
}
