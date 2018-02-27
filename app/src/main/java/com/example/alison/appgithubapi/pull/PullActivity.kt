package com.example.alison.appgithubapi.pull

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.data.model.pull.PullRequest
import com.example.alison.appgithubapi.data.model.repository.Items
import kotlinx.android.synthetic.main.activity_pull.*

class PullActivity : AppCompatActivity(), PullContract.View {

    override lateinit var presenter : PullContract.Presenter
    private lateinit var pullAdapter: PullAdapter
    private lateinit var item : Items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull)
        setupIntents()
        setupPresenter()
        setupRecyclerView()
        setupList()
    }

    override fun showProgressBar() { pbPull.visibility = View.VISIBLE }

    override fun hideProgressBar() { pbPull.visibility = View.GONE }

    override fun loadList(pullRequests: ArrayList<PullRequest>) {
        pullAdapter = PullAdapter(pullRequests)
        rvPull.adapter = pullAdapter
        setupHeader()
    }

    private fun setupList() { presenter.loadListPulls(item.owner.login, item.name) }

    private fun setupIntents() { item = intent.getParcelableExtra("item") }

    private fun setupRecyclerView() {
        rvPull.layoutManager = LinearLayoutManager(this)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvPull.addItemDecoration(itemDecoration)
    }

    private fun setupPresenter() {
        presenter = PullPresenter(this)
        presenter.start()
    }

    private fun setupHeader() {
        txtOpen.text = pullAdapter.itemCount.toString()
        txtClose.text = item.open_issues.toString()
    }
}
