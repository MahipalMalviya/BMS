package com.mahipal.common_ui.di

import android.content.Context
import com.mahipal.common_ui.imageloader.ImageLoaderImpl
import com.mahipal.core.ImageLoader
import dagger.Module
import dagger.Provides

@Module
class CommonModule {

    @Provides
    fun getImageLoader(
        context: Context
    ): ImageLoader {
        return ImageLoaderImpl(
            context = context
        )
    }
}