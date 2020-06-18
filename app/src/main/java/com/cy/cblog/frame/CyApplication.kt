package com.cy.cblog.frame

import android.app.Application

/**
 * Application
 * @author Cyong
 * @date 2020/6/16 17:05
 */
class CyApplication:Application() {

    public lateinit var currActivity:CActivity

    companion object {
        lateinit var instant: CyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instant = this
    }
}