package com.example.admintegrations.library.apis

import com.sdmc.platformapi.PlatformApi

class SDMCPlatformApiImpl(
    private val platformApi: PlatformApi
) : IntegrationsApi {

    override val buildInformation: String?
        get() = platformApi
            .buildInformation

    override val macAddress: String?
        get() = platformApi
            .macAddress

    override val runningAppList: List<String>
        get() = platformApi
            .runningAppList

    override val runningServiceList: List<String>
        get() = platformApi
            .runningServiceList
            .map { "${it.packageName}.${it.className}" }

    override val serialNumber: String?
        get() = platformApi
            .serialNumber

    override fun injectKeyEvent(
        keyCode: Int
    ) = platformApi.injectKeyEvent(
        /* keyCode = */ keyCode
    )

    override fun injectMotionEvent(
        x: Float,
        y: Float
    ) = platformApi.injectMotionEvent(
        /* x = */ x,
        /* y = */ y
    )

    override fun injectText(
        text: String
    ) = platformApi.injectText(
        /* text = */ text
    )

    override fun installApp(
        filePath: String,
        packageName: String
    ) = platformApi.installAPP(
        /* filePath = */ filePath,
        /* packageName = */ packageName
    )

    override fun removeApp(
        packageName: String
    ) = platformApi.removeAPP(
        /* packageName = */ packageName
    )


}
