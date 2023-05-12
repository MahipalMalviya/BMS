package com.mahipal.feature_one.di

import com.mahipal.core.di.CoreComponentProvider


object FeatureOneDaggerProvider {

    val component: FeatureOneComponent by lazy {
        DaggerFeatureOneComponent.factory().create(
            coreComponent = CoreComponentProvider.coreComponent
        )
    }
}