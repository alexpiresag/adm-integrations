package com.example.admintegrations

import androidx.lifecycle.ViewModel
import com.example.admintegrations.library.apis.IntegrationsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val integrationsApi: IntegrationsApi
) : ViewModel() {

    private val _label = MutableStateFlow("")
    val label = _label.asStateFlow()

    fun updateLabel(newLabel: String) {
        _label.value = newLabel
    }

    fun getSerialNumber(): String? {
        return integrationsApi.serialNumber
    }

    fun getMacAddress(): String? {
        return integrationsApi.macAddress
    }

    fun getRunningAppList(): List<String> {
        return integrationsApi.runningAppList
    }

    fun getRunningServiceList(): List<String> {
        return integrationsApi.runningServiceList
    }

    fun injectKeyEvent(keyCode: Int) {
        integrationsApi.injectKeyEvent(keyCode)
    }

    fun injectMotionEvent(x: Float, y: Float) {
        integrationsApi.injectMotionEvent(x, y)
    }

    fun injectText(text: String) {
        integrationsApi.injectText(text)
    }

    fun installApp(filePath: String, packageName: String) {
        integrationsApi.installApp(filePath, packageName)
    }

    fun removeApp(packageName: String) {
        integrationsApi.removeApp(packageName)
    }
}
