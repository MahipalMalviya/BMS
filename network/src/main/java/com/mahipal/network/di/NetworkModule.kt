package com.mahipal.network.di

import android.content.Context
import com.mahipal.core.NetworkManager
import com.mahipal.core.NetworkProvider
import com.mahipal.network.manager.NetworkManagerImpl
import com.mahipal.network.provider.NetworkProviderImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun getNetworkManager(
        context: Context
    ): NetworkManager {
        return NetworkManagerImpl(
            context = context
        )
    }

    @Provides
    fun getNetworkProvider(): NetworkProvider {
        return NetworkProviderImpl()
    }
}