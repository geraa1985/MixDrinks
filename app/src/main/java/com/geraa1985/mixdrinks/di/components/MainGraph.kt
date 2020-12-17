package com.geraa1985.mixdrinks.di.components

import com.geraa1985.mixdrinks.di.modules.CiceroneModule
import com.geraa1985.mixdrinks.mvp.presenter.base.MainPresenter
import com.geraa1985.mixdrinks.mvp.presenter.base.SelectPresenter
import com.geraa1985.mixdrinks.ui.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class
    ]
)
interface MainGraph {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(selectPresenter: SelectPresenter)
}