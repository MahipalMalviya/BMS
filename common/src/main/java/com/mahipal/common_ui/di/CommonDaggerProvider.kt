package com.mahipal.common_ui.di

object CommonDaggerProvider {

    val component: CommonComponent by lazy {
        DaggerCommonComponent.factory().create()
    }
}