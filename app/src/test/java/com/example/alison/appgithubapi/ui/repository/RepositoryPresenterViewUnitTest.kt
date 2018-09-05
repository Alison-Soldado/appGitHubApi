package com.example.alison.appgithubapi.ui.repository


import android.support.test.filters.SmallTest
import com.example.alison.appgithubapi.data.model.repository.Items
import com.example.alison.appgithubapi.data.model.repository.Owner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@SmallTest
@RunWith(MockitoJUnitRunner::class)
class RepositoryPresenterViewUnitTest {

    @Mock private lateinit var repositoryView : RepositoryContract.View

    private lateinit var repositoryPresenter : RepositoryContract.Presenter
    private var listItems : ArrayList<Items> = ArrayList()

    @Before
    fun setup() {
        // Arrange
        MockitoAnnotations.initMocks(this)
        repositoryPresenter = RepositoryPresenter(repositoryView)
        addItemsInList()
        repositoryPresenter.start()
    }

    @Test
    fun givenNumberPages_WhenLoadListRepository_ThenShowProgressBar(){
        // Act
        repositoryPresenter.loadListRepository()
        // Assert
        verify(repositoryView).showProgressBar()
    }

    @Test
    fun givenListItems_WhenCallBackList_ThenHideProgressBar() {
        // Act
        repositoryPresenter.callBackList(listItems)
        // Assert
        verify(repositoryView).hideProgressBar()
    }

    @Test
    fun givenListItems_WhenCallBackList_ThenLoadList() {
        // Act
        repositoryPresenter.callBackList(listItems)
        // Assert
        verify(repositoryView).loadList(listItems)
    }

    private fun addItemsInList() {
        listItems.add(0, Items(0, "", "", ownerTest(),
                "", "", 0, 0, 0))
        listItems.add(1, Items(0, "", "", ownerTest(),
                "", "", 0, 0, 0))
    }

    private fun ownerTest() = Owner(0, "", "", "", "")
}
