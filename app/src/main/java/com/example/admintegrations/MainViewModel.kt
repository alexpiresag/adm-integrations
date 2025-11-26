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

    fun macAddress(): String? {
        return integrationsApi.macAddress
    }
}
