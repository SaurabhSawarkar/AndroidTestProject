package com.example.myapplication.dashboard

import com.example.myapplication.base.BaseRepoImpl
import com.example.myapplication.dashboard.model.MoviesResponse
import com.example.myapplication.network.AppRxSchedulers
import io.reactivex.Observable

class DashboardRepoImpl(
    private val api: DashboardAPI,
) : BaseRepoImpl(), DashboardRepo {

    override fun getListOfMovies(language: String, page: Int): Observable<MoviesResponse> {
        return isInternetAvailable().toObservable().concatMap { isInternetAvailable ->
            if (isInternetAvailable) {
                api.getListOfMovies(language, page)
                    .subscribeOn(AppRxSchedulers.network())
            } else {
                Observable.error(Exception("Internet down"))
            }
        }
    }
}