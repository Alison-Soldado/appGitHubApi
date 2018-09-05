package com.example.alison.appgithubapi.ui.repository

import com.example.alison.appgithubapi.data.model.repository.Items
import com.example.alison.appgithubapi.data.source.local.UserDataSourceSP
import com.example.alison.appgithubapi.data.source.remote.repository.RepositoryDataSource


class RepositoryPresenter(private val repositoryView : RepositoryContract.View)
    : RepositoryContract.Presenter {

    private lateinit var repositoryDataSource : RepositoryDataSource
    private lateinit var userDataSourceSP : UserDataSourceSP

    override fun start() {
        repositoryView.presenter = this
        repositoryDataSource = RepositoryDataSource(this)
        userDataSourceSP = UserDataSourceSP()
    }

    override fun getEmail() { repositoryView.loadEmailHeader(userDataSourceSP.getUser().email) }

    override fun loadListRepository() {
        repositoryView.showProgressBar()
        repositoryDataSource.requestList()
    }

    override fun loadNextListRepository() {
        repositoryView.showFooter()
        repositoryDataSource.requestNextList()
    }

    override fun callBackList(items : ArrayList<Items>) {
        repositoryView.hideProgressBar()
        repositoryView.loadList(items)
    }

    override fun callBackNextList(items : ArrayList<Items>) {
        repositoryView.hideFooter()
        repositoryView.updateList(items)
    }

    override fun verifyUserLogged() {
        if (!userDataSourceSP.getUser().logged) {
            repositoryView.showLogin()
        }
    }

    override fun clearSharedPreferencesAndExit() {
        userDataSourceSP.clearUser()
        repositoryView.exitApplication()
    }
}
