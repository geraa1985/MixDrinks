package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.view.base.ISelectView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SelectPresenter: MvpPresenter<ISelectView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backClicked(): Boolean {
        router.exit()
        return true
    }
}