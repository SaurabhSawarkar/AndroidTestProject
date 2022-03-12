package com.example.myapplication.dashboard

import com.example.myapplication.dashboard.model.MoviesResponse
import io.reactivex.Observable

interface DashboardRepo {

    /**
     * Fetch the list of movies from the server
     *
     * @param language - language
     * @param page - page
     * @return - Observable of type MoviesResponse
     */
    fun getListOfMovies(language: String, page: Int): Observable<MoviesResponse>
}