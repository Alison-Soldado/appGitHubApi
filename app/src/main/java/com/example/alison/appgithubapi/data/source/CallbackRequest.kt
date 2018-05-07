package com.example.alison.appgithubapi.data.source

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by alissonsoldado on 20/04/18.
 */
abstract class CallbackRequest<T> : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            success(response.body()!!)

            return
        }
        failureHttp(response)
    }

    override fun onFailure(call: Call<T>, throwable: Throwable) {
        failure(throwable)
    }

    protected abstract fun success(response: T)

    protected abstract fun failureHttp(response: Response<T>)

    protected abstract fun failure(throwable: Throwable)
}