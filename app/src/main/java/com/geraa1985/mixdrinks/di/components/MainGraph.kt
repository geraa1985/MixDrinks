package com.geraa1985.mixdrinks.di.components

import com.geraa1985.mixdrinks.di.modules.*
import com.geraa1985.mixdrinks.mvp.model.entity.room.cache.CocktailsCache
import com.geraa1985.mixdrinks.mvp.model.repositoties.CocktailsRepo
import com.geraa1985.mixdrinks.mvp.presenter.base.CocktailPresenter
import com.geraa1985.mixdrinks.mvp.presenter.base.ListPresenter
import com.geraa1985.mixdrinks.mvp.presenter.base.MainPresenter
import com.geraa1985.mixdrinks.mvp.presenter.base.SelectPresenter
import com.geraa1985.mixdrinks.ui.activities.MainActivity
import com.geraa1985.mixdrinks.ui.adapters.CocktailsRVAdapter
import com.geraa1985.mixdrinks.ui.fragments.CocktailFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        NetworkModule::class,
        ReposModule::class,
        AppModule::class,
        CacheModule::class
    ]
)
interface MainGraph {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(selectPresenter: SelectPresenter)
    fun inject(listPresenter: ListPresenter)
    fun inject(cocktailsRVAdapter: CocktailsRVAdapter)
    fun inject(coctailsRepo: CocktailsRepo)
    fun inject(cocktailPresenter: CocktailPresenter)
    fun inject(cocktailFragment: CocktailFragment)
    fun inject(cocktailsCache: CocktailsCache)
}