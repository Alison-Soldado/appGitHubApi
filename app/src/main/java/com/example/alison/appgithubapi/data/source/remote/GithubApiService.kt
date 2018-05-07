package com.example.alison.appgithubapi.data.source.remote

import com.example.alison.appgithubapi.BuildConfig
import com.example.alison.appgithubapi.data.model.pull.PullRequest
import com.example.alison.appgithubapi.data.model.repository.Result
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    @GET("search/repositories?q=language:Java&sort=stars&")
    fun search(@Query("page") page: Int): io.reactivex.Observable<Result>

    @GET("repos/{login}/{name}/pulls")
    fun getPullRequest(
            @Path("login") login: String,
            @Path("name") name: String): io.reactivex.Observable<ArrayList<PullRequest>>
}