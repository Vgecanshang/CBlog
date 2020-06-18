package com.cy.cblog.frame

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

/**
 * class
 * @author Cyong
 * @date 2020/6/17 10:58
 */
open class CActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        CyApplication.instant.currActivity = this
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onResume() {
        CyApplication.instant.currActivity = this
        super.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        CyApplication.instant.currActivity = this
        super.onActivityResult(requestCode, resultCode, data)
    }

}