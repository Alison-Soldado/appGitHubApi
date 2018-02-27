package com.example.alison.appgithubapi.login

import com.example.alison.appgithubapi.R
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class LoginPresenterViewUnitTest {

    companion object {
        const val EMAIL = "exemplo@exemplo.com"
        const val PASSWORD = "123"
        const val EMAIL_INCORRECT = "teste@teste.com"
        const val PASSWORD_INCORRECT = "456"
        const val EMAIL_ERROR = "email error"
        const val EMPTY = ""
    }

    @Mock private lateinit var loginView : LoginContract.View

    private lateinit var loginPresenter : LoginContract.Presenter

    @Before
    fun setupLoginPresenter(){
        // Arrange
        MockitoAnnotations.initMocks(this)
        loginPresenter = LoginPresenter(loginView)
    }

    @Test
    fun givenEmailEmpty_WhenCallFunLogin_ThenCallFunEmailError(){
        // Act
        loginPresenter.login(EMPTY, PASSWORD)
        // Assert
        verify(loginView).setEmailError(R.string.msgErrorEmail)
    }

    @Test
    fun givenPasswordEmpty_WhenCallFunLogin_ThenCallFunPasswordError(){
        // Act
        loginPresenter.login(EMAIL, EMPTY)
        // Assert
        verify(loginView).setPasswordError(R.string.msgErrorPassword)
    }

    @Test
    fun givenEmailError_WhenCallFunLogin_ThenCallFunEmailError(){
        // Act
        loginPresenter.login(EMAIL_ERROR, PASSWORD)
        // Assert
        verify(loginView).setEmailError(R.string.msgErrorEmailValid)
    }

    @Test
    fun givenEmailAndPasswordIncorrect_WhenCallFunLogin_ThenShowUserAndPasswordIncorrect(){
        // Act
        loginPresenter.login(EMAIL_INCORRECT, PASSWORD_INCORRECT)
        // Assert
        verify(loginView).showUserAndPasswordIncorrect(R.string.msgErrorEmailPass)
    }

    @Test
    fun givenEmailAndPasswordCorrect_WhenCallFunLogin_ThenShowSuccessAndGoToMain() {
        // Act
        loginPresenter.login(EMAIL, PASSWORD)
        // Assert
        verify(loginView).showRepository()
    }
}