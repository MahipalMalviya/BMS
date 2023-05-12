package com.mahipal.assignment.repository

import com.mahipal.feature_one.model.ShowTimeResponse
import io.reactivex.Observable

interface ShowTimesRepository {
    fun getShowTimes(): Observable<ShowTimeResponse>
}