package com.cy.cblog.ui.main.wifi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * class
 * @author Cyong
 * @date 2020/6/17 10:00
 */
class WifiViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is wifi Fragment"
    }
    val text: LiveData<String> = _text
}