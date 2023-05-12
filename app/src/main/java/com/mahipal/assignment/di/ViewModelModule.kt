package com.mahipal.assignment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mahipal.assignment.viewmodel.MainViewModel
import com.mahipal.common_ui.viewmodel.ViewModelFactory
import com.mahipal.common_ui.viewmodel.ViewModelKey
import com.mahipal.common_ui.viewmodel.AppScoped
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @AppScoped
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainViewModel): ViewModel


}