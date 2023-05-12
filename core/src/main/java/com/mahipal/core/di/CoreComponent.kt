package com.mahipal.core.di

import android.content.Context
import com.mahipal.core.ImageLoader
import com.mahipal.core.NetworkManager
import com.mahipal.core.NetworkProvider

interface CoreComponent {

    fun getContext(): Context

    fun getImageLoader(): ImageLoader

    fun getNetworkProvider(): NetworkProvider

    fun getNetworkManager(): NetworkManager
}