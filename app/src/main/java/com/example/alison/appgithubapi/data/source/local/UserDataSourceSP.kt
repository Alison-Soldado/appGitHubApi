package com.example.alison.appgithubapi.data.source.local

import com.example.alison.appgithubapi.App
import com.example.alison.appgithubapi.data.model.login.UserLogin
import com.example.alison.appgithubapi.data.source.DataSource
import com.example.alison.appgithubapi.util.PreferencesUtil

class UserDataSourceSP: DataSource.UserDataSource {

    private val prefs = PreferencesUtil(App.instance)

    override fun setUser(email: String, password: String): Boolean {
        prefs.setSP("email", email)
        prefs.setSP("password", password)
        prefs.setSP("logged", true)
        return true
    }

    override fun getUser() = UserLogin(
            prefs.getSP("email"),
            prefs.getSP("password"),
            prefs.getSP("logged"))

    override fun clearUser() { prefs.clearSP() }
}
