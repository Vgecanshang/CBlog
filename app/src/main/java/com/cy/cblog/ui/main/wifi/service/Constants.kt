package com.cy.cblog.ui.main.wifi.service

import android.os.Environment
import com.cy.cblog.R
import com.cy.cblog.frame.CyApplication
import java.io.File

/**
 * class
 * @author Cyong
 * @date 2020/7/2 17:00
 */
class Constants {
    companion object{
        const val HTTP_PORT = 12345
        val DIR_FILE_SHARE_IN_SDCARD = CyApplication.instant.resources.getString(R.string.app_name)
        //26(8.0系统)以上的截图路径
        const val DIR_SCREENSHOT_IN_SDCARD_26 = "/DCIM/Screenshots"
        //26及以下(7.0、5.0等)的截图路径
        const val DIR_SCREENSHOT_IN_SDCARD = "/Pictures/Screenshots"
        const val MSG_DIALOG_DISMISS = 0
        val DIR = File(
            CyApplication.instant.filesDir.toString() + File.separator + DIR_FILE_SHARE_IN_SDCARD
        )
        val SCREENSHOT_DIR_26 = File(
            CyApplication.instant.filesDir.path + DIR_SCREENSHOT_IN_SDCARD_26
        )
        val SCREENSHOT_DIR = File(
            CyApplication.instant.filesDir.path + DIR_SCREENSHOT_IN_SDCARD
        )


    }
}