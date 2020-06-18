package com.cy.cblog.ui.login

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cy.cblog.data.LoginDataSource
import com.cy.cblog.data.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory(application: Application) : ViewModelProvider.AndroidViewModelFactory(
    application
) {
    private val cyApplication:Application = application

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource()
                ),application = cyApplication
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            return LoginViewModel(
//                    loginRepository = LoginRepository(
//                            dataSource = LoginDataSource()
//                    )
//            ,application ) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
}