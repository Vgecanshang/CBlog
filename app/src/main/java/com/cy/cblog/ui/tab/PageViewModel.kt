package com.cy.cblog.ui.tab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cy.cblog.R
import com.cy.cblog.frame.CyApplication

class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        val tips = CyApplication.instant.currActivity.resources.getString(R.string.large_text)
        "Hello world from section: $it \n\n $tips"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}