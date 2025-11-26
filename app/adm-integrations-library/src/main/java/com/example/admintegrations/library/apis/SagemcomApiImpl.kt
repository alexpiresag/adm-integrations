package com.example.admintegrations.library.apis

import android.content.ComponentName
import android.content.Context
import android.content.Context.BIND_AUTO_CREATE
import android.content.ServiceConnection
import android.os.IBinder
import com.sagemcom.stb.StbManager

/**
 * Connects to StbManager on Sagemcom stbs using AIDL
 * */
class SagemcomApiImpl constructor(private val context: Context) : IntegrationsApi  {
    private var connection: ServiceConnection? = null
    var stbManager: StbManager? = null


    private fun bindService() {
        val conn = object : ServiceConnection {
            override fun onServiceConnected(
                name: ComponentName?,
                boundService: IBinder?
            ) {
                stbManager = StbManager(boundService)
            }
            override fun onServiceDisconnected(name: ComponentName?) {
                stbManager = null
            }
        }
        connection = conn
        context.bindService(StbManager.getStbServiceIntent(), conn, BIND_AUTO_CREATE)
    }

    private fun unbindService() {
        connection?.let {
            context.unbindService(it)
        }
        connection = null
        stbManager = null
    }

    override val buildInformation: String?
        get() = TODO("Not yet implemented")

    override val macAddress: String?
        get() = stbManager?.platformAPI!!.macAddress

    override val runningAppList: List<String>
        get() = TODO("Not yet implemented")

    override val runningServiceList: List<String>
        get() = TODO("Not yet implemented")

    override val serialNumber: String?
        get() = stbManager?.platformAPI!!.serialNumber

    override fun injectKeyEvent(keyCode: Int) {
        TODO("Not yet implemented")
    }

    override fun injectMotionEvent(x: Float, y: Float) {
        TODO("Not yet implemented")
    }

    override fun injectText(text: String) {
        TODO("Not yet implemented")
    }

    override fun installApp(filePath: String, packageName: String) {
        TODO("Not yet implemented")
    }

    override fun removeApp(packageName: String) {
        TODO("Not yet implemented")
    }

    override fun screenShots(filePath: String) {
        TODO("Not yet implemented")
    }


}