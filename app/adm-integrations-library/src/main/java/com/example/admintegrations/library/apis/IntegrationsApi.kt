package com.example.admintegrations.library.apis

interface IntegrationsApi {

    val buildInformation: String?
    val macAddress: String?
    val runningAppList: List<String>
    val runningServiceList: List<String>
    val serialNumber: String?

    fun injectKeyEvent(
        keyCode: Int
    )

    fun injectMotionEvent(
        x: Float,
        y: Float
    )

    fun injectText(
        text: String
    )

    fun installApp(
        filePath: String,
        packageName: String
    )

    fun removeApp(
        packageName: String
    )

    fun screenShots(
        filePath: String
    )

}
