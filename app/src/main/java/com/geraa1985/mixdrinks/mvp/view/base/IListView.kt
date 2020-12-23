package com.geraa1985.mixdrinks.mvp.view.base

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IListView: MvpView {
    fun initRvCoctails()
    fun updateCoctailsList()
    fun showError(message: String)
    fun setIsAlco()
}