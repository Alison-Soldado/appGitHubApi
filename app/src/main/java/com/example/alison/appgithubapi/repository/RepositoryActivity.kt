package com.example.alison.appgithubapi.repository

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import com.example.alison.appgithubapi.R
import com.example.alison.appgithubapi.data.model.repository.Items
import com.example.alison.appgithubapi.login.LoginActivity
import com.example.alison.appgithubapi.util.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_repository.*


class RepositoryActivity : AppCompatActivity(), RepositoryContract.View {

    override lateinit var presenter : RepositoryContract.Presenter
    private lateinit var scrollListener : EndlessRecyclerViewScrollListener
    private lateinit var adapter : RepositoryAdapter
    private val materialInterpolator = FastOutSlowInInterpolator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)
        setupPresenter()
        setupHeader()
        setupRecyclerView()
        setupList()
        setSupportActionBar(toolbarRepository)
        setupUserLogin()
    }

    override fun showProgressBar() { progressBarMain.visibility = View.VISIBLE }

    override fun hideProgressBar() { progressBarMain.visibility = View.GONE }

    override fun showFooter() {
        linearFooter
                .animate()
                .translationY(0F)
                .setDuration(300)
                .setInterpolator(materialInterpolator)
                .start()
    }

    override fun hideFooter() {
        linearFooter
                .animate()
                .translationY(linearFooter.height.toFloat())
                .setDuration(300)
                .setInterpolator(materialInterpolator)
                .start()
    }

    override fun showLogin() {
        val itLogin = Intent(this, LoginActivity::class.java)
        startActivity(itLogin)
    }

    override fun loadEmailHeader(email: String) { txtWelcome.text = email }

    override fun loadList(items : ArrayList<Items>) {
        adapter = RepositoryAdapter(items)
        rvRepository.adapter = adapter

        scrollListener = object : EndlessRecyclerViewScrollListener(rvRepository.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                presenter.loadNextListRepository()
            }
        }

        rvRepository.addOnScrollListener(scrollListener)
    }

    override fun exitApplication() {
        val itLogin = Intent(this, LoginActivity::class.java)
        startActivity(itLogin)
        finish()
    }

    override fun updateList(items : ArrayList<Items>) {
        adapter.updateList(items)
        scrollListener.setState(items.size, true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search_repository, menu)
        val search = menu?.findItem(R.id.searchRepository)
        val searchView = search?.actionView as SearchView
        searchTitleRepository(searchView)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.exit -> {
                clearAllSharedPreferencesAndExit()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupList() { presenter.loadListRepository() }

    private fun clearAllSharedPreferencesAndExit() { presenter.clearSharedPreferencesAndExit() }

    private fun setupHeader() { presenter.getEmail() }

    private fun setupRecyclerView() {
        rvRepository.layoutManager = LinearLayoutManager(this)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvRepository.addItemDecoration(itemDecoration)
    }

    private fun setupPresenter() {
        presenter = RepositoryPresenter(this)
        presenter.start()
    }

    private fun setupUserLogin() { presenter.verifyUserLogged() }

    private fun searchTitleRepository(search: SearchView) {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String) = false

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                scrollListener.setState(false)
                return true
            }
        })
    }
}
