package com.mahipal.network.di

object DaggerProvider {

    val component: NetworkComponent by lazy {
        DaggerNetworkComponent.factory().create()
    }
}