package com.mahipal.assignment

import android.app.Application
import com.mahipal.assignment.di.AppComponent
import com.mahipal.assignment.di.DaggerAppComponent
import com.mahipal.assignment.di.DaggerAppComponentProvider
import com.mahipal.core.di.CoreComponentProvider

class AssignmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appComponent: AppComponent = DaggerAppComponent.factory().create(this)
        DaggerAppComponentProvider.setAppComponent(appComponent)
        CoreComponentProvider.coreComponent = appComponent
    }
}