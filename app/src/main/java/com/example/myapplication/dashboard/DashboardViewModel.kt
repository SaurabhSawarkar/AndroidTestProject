package com.example.myapplication.dashboard

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.dashboard.model.Results
import com.example.myapplication.network.AppRxSchedulers

class DashboardViewModel(private val dashboardRepo: DashboardRepo) : BaseViewModel() {
    val response = MutableLiveData<List<Results>>()
    val error = MutableLiveData<Throwable>()

    val test1 = 0
    val test2 = 0
    val test3 = 0

    fun fetchListOfMovies() {
        val disposable =
            dashboardRepo.getListOfMovies("en-US", 1).observeOn(AppRxSchedulers.mainThread())
                .subscribe({
                    response.postValue(it.results)
                }, {
                    error.postValue(it)
                })

        addDisposable(disposable)
    }
}