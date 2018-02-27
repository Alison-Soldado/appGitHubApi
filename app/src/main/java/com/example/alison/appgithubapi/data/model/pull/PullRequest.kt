package com.example.alison.appgithubapi.data.model.pull

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class PullRequest(
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String,
        @SerializedName("state") val state: String,
        @SerializedName("html_url") val html_url: String? = null,
        @SerializedName("created_at") val created_at: String,
        @SerializedName("user") val user: User
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class User (
        @SerializedName("login") val login: String,
        @SerializedName("id") val id: Long = 0,
        @SerializedName("avatar_url") val avatar_url: String? = null,
        @SerializedName("url") val url: String? = null,
        @SerializedName("html_url") val html_url: String? = null
) : Parcelable