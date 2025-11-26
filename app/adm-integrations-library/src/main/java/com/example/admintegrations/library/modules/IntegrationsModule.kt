package com.example.admintegrations.library.modules

import com.example.admintegrations.library.SagemcomApi
import org.koin.dsl.module

val sagemcomModule = module {
    single { SagemcomApi(get()) }
}