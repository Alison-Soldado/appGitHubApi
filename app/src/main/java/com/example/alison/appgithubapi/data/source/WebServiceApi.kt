package com.example.alison.appgithubapi.data.source

import com.example.alison.appgithubapi.data.model.pull.PullRequest
import com.example.alison.appgithubapi.data.model.repository.Items
import com.example.alison.appgithubapi.data.model.repository.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by alissonsoldado on 20/04/18.
 */
interface WebServiceApi {
    @GET("search/repositories?q=language:Java&sort=stars&")
    fun getRepositoryRequest(@Query("page") page: Int): Call<Result>

    @GET("repos/{login}/{name}/pulls")
    fun getPullRequest(
            @Path("login") login: String,
            @Path("name") name: String): Call<ArrayList<PullRequest>>
}