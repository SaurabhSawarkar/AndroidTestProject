package com.example.myapplication.network

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object AppRxSchedulers {
    private val database: Scheduler = Schedulers.single()
    private val network: Scheduler = Schedulers.io()
    private val mainThread: Scheduler = AndroidSchedulers.mainThread()


    fun network(): Scheduler = network

    fun mainThread(): Scheduler = mainThread

    fun database(): Scheduler = database
}