package com.example.alison.appgithubapi.data.model.repository

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Items(
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("full_name") val full_name: String,
        @SerializedName("owner") val owner: Owner,
        @SerializedName("html_url") val html_url: String,
        @SerializedName("description") val description: String,
        @SerializedName("forks_count") val forks_count: Long,
        @SerializedName("stargazers_count") val stargazers_count: Long,
        @SerializedName("open_issues") val open_issues: Long
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Owner (
        @SerializedName("id") val id: Long,
        @SerializedName("login") val login: String,
        @SerializedName("avatar_url") val avatar_url: String,
        @SerializedName("url") val url: String,
        @SerializedName("html_url") val htmlUrl: String
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Result (
        @SerializedName("items") val items: ArrayList<Items>
) : Parcelable