package com.geraa1985.mixdrinks.di.modules

import android.widget.ImageView
import com.geraa1985.mixdrinks.mvp.model.repositoties.CocktailsRepo
import com.geraa1985.mixdrinks.mvp.model.repositoties.ICocktailsRepo
import com.geraa1985.mixdrinks.mvp.model.repositoties.ILoadImage
import com.geraa1985.mixdrinks.ui.imageloader.GlideImgLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReposModule {

    @Singleton
    @Provides
    fun imgRepo(): ILoadImage<ImageView> = GlideImgLoader()

    @Singleton
    @Provides
    fun coctailRepo(): ICocktailsRepo = CocktailsRepo()
}