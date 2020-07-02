package com.cy.cblog.ui.main.wifi.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.text.TextUtils
import com.koushikdutta.async.AsyncServer
import com.koushikdutta.async.http.server.AsyncHttpServer
import com.koushikdutta.async.http.server.AsyncHttpServerRequest
import com.koushikdutta.async.http.server.AsyncHttpServerResponse
import java.io.*


/**
 * class
 * @author Cyong
 * @date 2020/7/2 16:43
 */
class WebService : Service() {

    companion object {
        const val ACTION_START_WEB_SERVICE = "com.cy.cblog.wifi.action.START_WEB_SERVICE"
        const val ACTION_STOP_WEB_SERVICE = "com.cy.cblog.wifi.action.STOP_WEB_SERVICE"

        const val TYPE_TEXT_CONTENT = "text/html;charset=utf-8"
        const val TYPE_CSS_CONTENT = "text/css;charset=utf-8"
        const val TYPE_BINARY_CONTENT = "application/octet-stream"
        const val TYPE_JS_CONTENT = "application/javascript"
        const val TYPE_PNG_CONTENT = "application/x-png"
        const val TYPE_JPG_CONTENT = "application/jpeg"
        const val TYPE_SWF_CONTENT = "application/x-shockwave-flash"
        const val TYPE_WOFF_CONTENT = "application/x-font-woff"
        const val TYPE_TTF_CONTENT = "application/x-font-truetype"
        const val TYPE_SVG_CONTENT = "image/svg+xml"
        const val TYPE_EOT_CONTENT = "image/vnd.ms-fontobject"
        const val TYPE_MP3_CONTENT = "audio/mp3"
        const val TYPE_MP4_CONTENT = "video/mpeg4"
        const val TYPE_APK_CONTENT = "application/vnd.android.package-archive"
        private var isStarted = false

        fun start(context: Context?) {
            val intent = Intent(context, WebService::class.java)
            intent.action = ACTION_START_WEB_SERVICE
            context?.startActivity(intent)
        }

        fun stop(context: Context?) {
            val intent = Intent(context, WebService::class.java)
            intent.action = ACTION_STOP_WEB_SERVICE
            context?.startActivity(intent)
        }

    }

    var server = AsyncHttpServer()
    var mAsyncServer = AsyncServer()

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var action = intent?.action
        if (ACTION_START_WEB_SERVICE == action) {
            isStarted = true
        } else if (ACTION_STOP_WEB_SERVICE == action) {
            isStarted = false
        }

        return super.onStartCommand(intent, flags, startId)
    }

    /**
     * 启动服务
     */
    private fun startService() {
//        server.get("")
    }

    private fun sendResources(
        request: AsyncHttpServerRequest,
        response: AsyncHttpServerResponse
    ) {
        try {
            var fullPath = request.path
            fullPath = fullPath.replace("%20", " ")
            var resourceName = fullPath
            if (resourceName.startsWith("/")) {
                resourceName = resourceName.substring(1)
            }
            if (resourceName.indexOf("?") > 0) {
                resourceName = resourceName.substring(0, resourceName.indexOf("?"))
            }
            if (!TextUtils.isEmpty(getContentTypeByResourceName(resourceName))) {
                response.setContentType(getContentTypeByResourceName(resourceName))
            }
            val bInputStream =
                BufferedInputStream(assets.open("wifi/$resourceName"))
            response.sendStream(bInputStream, bInputStream.available().toLong())
        } catch (e: IOException) {
            e.printStackTrace()
            response.code(404).end()
            return
        }
    }

    private fun getContentTypeByResourceName(resourceName: String): String? {
        return when{
            resourceName.endsWith(".css") ->{
                TYPE_CSS_CONTENT
            }
            resourceName.endsWith(".js") ->{
                TYPE_JS_CONTENT
            }

            else -> ""
        }



//        if (resourceName.endsWith(".css")) {
//            return cy.com.wifitransfer.WebService.CSS_CONTENT_TYPE
//        } else if (resourceName.endsWith(".js")) {
//            return cy.com.wifitransfer.WebService.JS_CONTENT_TYPE
//        } else if (resourceName.endsWith(".swf")) {
//            return cy.com.wifitransfer.WebService.SWF_CONTENT_TYPE
//        } else if (resourceName.endsWith(".png")) {
//            return cy.com.wifitransfer.WebService.PNG_CONTENT_TYPE
//        } else if (resourceName.endsWith(".jpg") || resourceName.endsWith(".jpeg")) {
//            return cy.com.wifitransfer.WebService.JPG_CONTENT_TYPE
//        } else if (resourceName.endsWith(".woff")) {
//            return cy.com.wifitransfer.WebService.WOFF_CONTENT_TYPE
//        } else if (resourceName.endsWith(".ttf")) {
//            return cy.com.wifitransfer.WebService.TTF_CONTENT_TYPE
//        } else if (resourceName.endsWith(".svg")) {
//            return cy.com.wifitransfer.WebService.SVG_CONTENT_TYPE
//        } else if (resourceName.endsWith(".eot")) {
//            return cy.com.wifitransfer.WebService.EOT_CONTENT_TYPE
//        } else if (resourceName.endsWith(".mp3")) {
//            return cy.com.wifitransfer.WebService.MP3_CONTENT_TYPE
//        } else if (resourceName.endsWith(".mp4")) {
//            return cy.com.wifitransfer.WebService.MP4_CONTENT_TYPE
//        } else if (resourceName.endsWith(".apk")) {
//            return cy.com.wifitransfer.WebService.APK_CONTENT_TYPE
//        }
//        return ""
    }


    class FileUploadHolder {
        var fileName: String = ""
            set(value) {
                totalSize = 0
                if (Constants.DIR.exists()) {
                    Constants.DIR.mkdirs()
                    receivedFile = File(Constants.DIR, value)
                    fileOutputStream = BufferedOutputStream(FileOutputStream(receivedFile))
                }
            }
        var receivedFile: File? = null
        var fileOutputStream: BufferedOutputStream? = null
        var totalSize: Long = 0

        fun reset() {
            try {
                fileOutputStream?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            fileOutputStream = null
        }

        fun write(data: ByteArray) {
            try {
                fileOutputStream?.write(data)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            totalSize += data.size.toLong()
        }


    }

}