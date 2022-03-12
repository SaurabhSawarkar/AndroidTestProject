package com.example.myapplication

import android.app.Application
import com.example.myapplication.network.networkModule
import com.example.myapplication.pref.TokenPref
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        val pres = TokenPref(this@TestApplication)
        pres.setAPIKey("38a73d59546aa378980a88b645f487fc")

        startKoin {
            androidContext(this@TestApplication)
            modules(listOf(networkModule, testApplicationModule))
        }
    }
}