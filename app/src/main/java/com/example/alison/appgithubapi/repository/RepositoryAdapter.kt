package com.example.alison.appgithubapi.repository

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.bumptech.glide.Glide
import com.example.alison.appgithubapi.App
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.data.model.repository.Items
import com.example.alison.appgithubapi.extension.ctx
import com.example.alison.appgithubapi.pull.PullActivity
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryAdapter(private var items: ArrayList<Items>)
    : RecyclerView.Adapter<RepositoryAdapter.MainViewHolder>(), Filterable {

    private var listRepositoryFilter = items

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = LayoutInflater
                .from(parent?.ctx)
                .inflate(R.layout.item_repository, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindForecast(listRepositoryFilter[position])
    }

    override fun getItemCount() = listRepositoryFilter.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val charString = charSequence.toString()

                listRepositoryFilter = if (charString.isEmpty()) {
                    items
                } else {
                    val filteredList = ArrayList<Items>()
                    items.filterTo(filteredList) { it.name.toLowerCase().contains(charString) }
                    filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = listRepositoryFilter
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listRepositoryFilter = results?.values as ArrayList<Items>
                notifyDataSetChanged()
            }

        }
    }

    class MainViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val username = itemView.txtUsername
        private val nameItem = itemView.txtNameItem
        private val descriptionItem = itemView.txtDescriptionItem
        private val branchCount = itemView.txtBranchCount
        private val starCount = itemView.txtStarCount
        private val imageUser = itemView.imgUser

        fun bindForecast(item: Items) {
            Glide
                    .with(App.instance)
                    .load(item.owner.avatar_url)
                    .centerCrop()
                    .into(imageUser)

            username.text = item.owner.login
            nameItem.text = item.name
            descriptionItem.text = item.description
            branchCount.text = item.forks_count.toString()
            starCount.text = item.stargazers_count.toString()
            itemView.setOnClickListener{showPull(item)}
        }

        private fun showPull(item: Items) {
            val itPull = Intent(App.instance, PullActivity::class.java)
            itPull.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            itPull.putExtra("item", item)
            App.instance.startActivity(itPull)
        }
    }

    fun updateList(items : ArrayList<Items>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}