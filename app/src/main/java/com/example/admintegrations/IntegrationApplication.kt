package com.example.admintegrations

import android.app.Application
import com.example.admintegrations.library.di.integrationModule
import com.example.admintegrations.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class IntegrationApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@IntegrationApplication)
            modules(appModule,integrationModule)
        }
    }
}