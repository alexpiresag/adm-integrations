package com.example.admintegrations.di

import com.example.admintegrations.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel(integrationsApi = get())
    }
}