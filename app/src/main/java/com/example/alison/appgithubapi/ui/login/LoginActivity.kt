package com.example.alison.appgithubapi.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.alison.appgithubapi.BuildConfig
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.extension.setErrorAndFocus
import com.example.alison.appgithubapi.extension.showToast
import com.example.alison.appgithubapi.ui.repository.RepositoryActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override lateinit var presenter : LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupPresenter()
        setupClickButton()
        setupLongClickButton()
        setupUserLogin()
    }

    override fun setEmailError(errorRes : Int) = edtEmailLogin.setErrorAndFocus(errorRes)

    override fun setPasswordError(errorRes : Int) = edtPasswordLogin.setErrorAndFocus(errorRes)

    override fun showUserAndPasswordIncorrect(message : Int) = showToast(getString(message))

    override fun showProgressBar() { pbLogin.visibility = View.VISIBLE }

    override fun hideProgressBar() { pbLogin.visibility = View.GONE }

    override fun showSuccess(message : Int) { showToast(getString(message)) }

    override fun showRepository() {
        val itMain = Intent(this, RepositoryActivity::class.java)
        startActivity(itMain)
        finish()
    }

    private fun setupLongClickButton() {
        if (BuildConfig.DEBUG) {
            btnEnter.setOnLongClickListener {
                edtEmailLogin.setText(R.string.contentEmail)
                edtPasswordLogin.setText(R.string.contentPassword)
                true
            }
        }
    }

    private fun setupPresenter() {
        presenter = LoginPresenter(this)
        presenter.start()
    }

    private fun setupClickButton() {
        btnEnter.setOnClickListener {
            presenter.login(edtEmailLogin.text.toString(), edtPasswordLogin.text.toString()) }
    }

    private fun setupUserLogin() { presenter.verifyUserLogged() }
}
