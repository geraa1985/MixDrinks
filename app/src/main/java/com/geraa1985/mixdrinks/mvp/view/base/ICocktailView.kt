package com.geraa1985.mixdrinks.mvp.view.base

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ICocktailView : MvpView {
    fun showError(message: String)
    fun setId()
    fun showPicture(url: String)
    fun showName(name: String)
}