package com.example.admintegrations.library.di

import android.util.Log
import com.example.admintegrations.library.DeviceManufacturers.SAGEMCOM
import com.example.admintegrations.library.apis.IntegrationsApi
import com.example.admintegrations.library.apis.SDMCPlatformApiImpl
import com.example.admintegrations.library.apis.SagemcomApiImpl
import com.sdmc.platformapi.PlatformApi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val integrationModule = module {
    single<IntegrationsApi> {
        val manufacturer = android.os.Build.MANUFACTURER.lowercase()
        Log.i("INT", "manufacturer: $manufacturer")
        when {
            SAGEMCOM in manufacturer -> SagemcomApiImpl(androidApplication())
            else -> SDMCPlatformApiImpl(
                    platformApi = PlatformApi(
                    androidApplication()
                    )
            )
        }
    }
}