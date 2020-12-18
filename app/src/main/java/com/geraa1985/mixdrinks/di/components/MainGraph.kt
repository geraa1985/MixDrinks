package com.geraa1985.mixdrinks.di.components

import com.geraa1985.mixdrinks.di.modules.AppModule
import com.geraa1985.mixdrinks.di.modules.CiceroneModule
import com.geraa1985.mixdrinks.di.modules.NetworkModule
import com.geraa1985.mixdrinks.di.modules.ReposModule
import com.geraa1985.mixdrinks.mvp.model.repositoties.CoctailsRepo
import com.geraa1985.mixdrinks.mvp.presenter.base.ListPresenter
import com.geraa1985.mixdrinks.mvp.presenter.base.MainPresenter
import com.geraa1985.mixdrinks.mvp.presenter.base.SelectPresenter
import com.geraa1985.mixdrinks.ui.activities.MainActivity
import com.geraa1985.mixdrinks.ui.adapters.CoctailsRVAdapter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        NetworkModule::class,
        ReposModule::class,
        AppModule::class
    ]
)
interface MainGraph {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(selectPresenter: SelectPresenter)
    fun inject(listPresenter: ListPresenter)
    fun inject(coctailsRVAdapter: CoctailsRVAdapter)
    fun inject(coctailsRepo: CoctailsRepo)
}