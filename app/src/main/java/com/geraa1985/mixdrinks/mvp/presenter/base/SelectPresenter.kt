package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.view.base.ISelectView
import com.geraa1985.mixdrinks.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SelectPresenter: MvpPresenter<ISelectView>() {

    @Inject
    lateinit var router: Router

    fun loadAlcoholList() {
        router.navigateTo(Screens.listScreen(true))
    }

    fun loadNonAlcoholList() {
        router.navigateTo(Screens.listScreen(false))
    }

    fun backClicked(): Boolean {
        router.exit()
        return true
    }
}