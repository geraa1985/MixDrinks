package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.view.base.IMainView
import com.geraa1985.mixdrinks.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter: MvpPresenter<IMainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootChain(Screens.selectScreen())
    }

    fun backClicked() {
        router.exit()
    }

}