package com.example.myapplication.dashboard

import com.example.myapplication.dashboard.model.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DashboardAPI {
    @GET("movie/popular")
    fun getListOfMovies(@Query("language") language: String, @Query("page") page: Int)
            : Observable<MoviesResponse>
}