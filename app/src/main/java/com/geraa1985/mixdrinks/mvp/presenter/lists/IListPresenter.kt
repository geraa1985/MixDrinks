package com.geraa1985.mixdrinks.mvp.presenter.lists

import com.geraa1985.mixdrinks.mvp.view.lists.IItemView

interface IListPresenter<V: IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}