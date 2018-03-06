package com.example.alison.appgithubapi.repository

import com.example.alison.appgithubapi.data.source.DataSource
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class RepositoryPresenterDataSourceUnitTest {

    @Mock private lateinit var repositoryDataSource : DataSource.RepoDataSource

    private lateinit var repositoryPresenter : RepositoryContract.Presenter

    @Test
    fun givenEmailAndPasswordCorrect_WhenClickButtonClick_ThenShouldGetEmail() {

    }

    @Test
    fun givenPageStart_WhenLoadListRepository_ThenRequestList() {
        // Act
        repositoryPresenter.loadListRepository()
        // Assert
        Mockito.verify(repositoryDataSource).requestList()
    }

    @Test
    fun givenRequestNextPageList_WhenFinalListRepository_ThenLoadNextList() {

    }

    @Test
    fun givenEmailAndPasswordSaved_WhenUserEnterAppAgain_ThenShouldVerifyUserLogged() {

    }

    @Test
    fun givenIntentExitApp_WhenUserClickMenuExit_ThenShouldClearSharedPreferencesAndExitApplication() {

    }
}