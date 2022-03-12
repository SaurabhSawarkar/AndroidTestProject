package com.example.myapplication

import com.example.myapplication.dashboard.DashboardAPI
import com.example.myapplication.dashboard.DashboardRepo
import com.example.myapplication.dashboard.DashboardRepoImpl
import com.example.myapplication.dashboard.DashboardViewModel
import com.example.myapplication.network.Environment
import com.example.myapplication.network.EnvironmentManager
import com.example.myapplication.network.RETROFIT
import com.example.myapplication.network.createWebService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val testApplicationModule = module(override = true) {
    single<DashboardRepo> {
        DashboardRepoImpl(
            createWebService<DashboardAPI>(get(named(RETROFIT)))
        )
    }
    factory { EnvironmentManager(Environment.Type.DEBUG) }
    viewModel { DashboardViewModel(get()) }
}