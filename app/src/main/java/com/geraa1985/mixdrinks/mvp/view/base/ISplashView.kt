package com.geraa1985.mixdrinks.mvp.view.base

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface ISplashView: MvpView {
    fun go()
    fun theEnd()
}