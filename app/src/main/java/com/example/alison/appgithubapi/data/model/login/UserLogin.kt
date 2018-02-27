package com.example.alison.appgithubapi.data.model.login

data class UserLogin(
        var email: String,
        var password : String,
        var logged: Boolean = false
)