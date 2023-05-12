package com.mahipal.assignment.repository

import com.mahipal.feature_one.model.ShowTimeResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface ShowTimesAPI {

    @GET("/movie_showtimes")
    fun getShowTimes(): Observable<ShowTimeResponse>
}