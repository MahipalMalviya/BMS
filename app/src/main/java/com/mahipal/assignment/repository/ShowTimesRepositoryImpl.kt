package com.mahipal.assignment.repository

import com.mahipal.feature_one.model.ShowTimeResponse
import com.mahipal.core.NetworkProvider
import io.reactivex.Observable
import javax.inject.Inject

class ShowTimesRepositoryImpl @Inject constructor(
    private val networkProvider: NetworkProvider
) : ShowTimesRepository {

    private val api: ShowTimesAPI
        get() = networkProvider.getApi(
            apiClass = ShowTimesAPI::class.java,
            baseUrl = "https://demo2782755.mockable.io"
        )

    override fun getShowTimes(): Observable<ShowTimeResponse> {
        return api.getShowTimes()
    }
}