package com.mahipal.assignment.di

import android.content.Context
import com.mahipal.assignment.MainActivity
import com.mahipal.common_ui.di.CommonModule
import com.mahipal.common_ui.viewmodel.AppScoped
import com.mahipal.core.di.CoreComponent
import com.mahipal.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component

@AppScoped
@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}