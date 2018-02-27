package com.example.alison.appgithubapi.pull

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.alison.appgithubapi.App
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.data.model.pull.PullRequest
import com.example.alison.appgithubapi.extension.ctx
import com.example.alison.appgithubapi.extension.formatToBrazil
import kotlinx.android.synthetic.main.item_pull.view.*

class PullAdapter(private var pullRequest: ArrayList<PullRequest>)
    : RecyclerView.Adapter<PullAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = LayoutInflater
                .from(parent?.ctx)
                .inflate(R.layout.item_pull, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindForecast(pullRequest[position])
    }

    override fun getItemCount() = pullRequest.size

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = itemView.txtTitle
        private val body = itemView.txtBody
        private val imageUserPull = itemView.imgUserPull
        private val nameFull = itemView.txtFullName
        private val dataCreate = itemView.txtDataPull

        fun bindForecast(pullRequest: PullRequest) {
            with(pullRequest) {
                Glide
                        .with(App.instance)
                        .load(pullRequest.user.avatar_url)
                        .centerCrop()
                        .into(imageUserPull)

            }

            title.text = pullRequest.title
            body.text = pullRequest.body
            nameFull.text = pullRequest.user.login
            dataCreate.text = pullRequest.created_at.formatToBrazil()
            itemView.setOnClickListener{showPageWeb(pullRequest)}
        }

        private fun showPageWeb(pullRequest: PullRequest) {
            val itPull = Intent(Intent.ACTION_VIEW, Uri.parse(pullRequest.html_url))
            App.instance.startActivity(itPull)
        }
    }
}