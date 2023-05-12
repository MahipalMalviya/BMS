package com.mahipal.assignment.di

import com.mahipal.assignment.repository.ShowTimesRepository
import com.mahipal.assignment.repository.ShowTimesRepositoryImpl
import com.mahipal.core.NetworkProvider
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideShowTimeRepository(networkProvider: NetworkProvider): ShowTimesRepository {
        return ShowTimesRepositoryImpl(networkProvider)
    }
}