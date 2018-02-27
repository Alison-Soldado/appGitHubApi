package com.example.alison.appgithubapi.data.source

import com.example.alison.appgithubapi.data.model.login.UserLogin


interface DataSource {

    interface UserDataSource {
        fun setUser(email: String, password: String) : Boolean
        fun getUser(): UserLogin
        fun clearUser()
    }

    interface RepoDataSource {
        fun requestList()
        fun requestNextList()
    }

    interface PullDataSource {
        fun requestListPull(login: String, name: String)
    }
}