package com.example.admintegrations.library

import android.content.ComponentName
import android.content.Context
import android.content.Context.BIND_AUTO_CREATE
import android.content.ServiceConnection
import android.os.IBinder
import com.sagemcom.stb.StbManager

/**
 * Connects to StbManager on Sagemcom stbs using AIDL
 * */
class SagemcomApi constructor(private val context: Context)  {
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

    public fun serialNumber(): String {
        return stbManager?.platformAPI!!.serialNumber
    }

    public fun macAddress(): String {
        return stbManager?.platformAPI!!.macAddress
    }


}