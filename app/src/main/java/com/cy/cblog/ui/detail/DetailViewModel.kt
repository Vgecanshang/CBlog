package com.cy.cblog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cy.cblog.R
import com.cy.cblog.frame.CyApplication

/**
 * class
 * @author Cyong
 * @date 2020/6/17 16:02
 */
class DetailViewModel:ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = CyApplication.instant.resources.getString(R.string.large_text)
    }
    val text: LiveData<String> = _text
}