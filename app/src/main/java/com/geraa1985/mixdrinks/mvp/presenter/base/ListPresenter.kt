package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.model.entity.base.Coctail
import com.geraa1985.mixdrinks.mvp.model.repositoties.ICoctailsRepo
import com.geraa1985.mixdrinks.mvp.presenter.lists.ICoctailListPresenter
import com.geraa1985.mixdrinks.mvp.view.base.IListView
import com.geraa1985.mixdrinks.mvp.view.lists.ICoctailItemView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ListPresenter : MvpPresenter<IListView>() {

    init {
        viewState.setIsAlco()
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var coctailsRepo: ICoctailsRepo

    @Inject
    lateinit var uiScheduler: Scheduler

    private var isAlco: Boolean? = null

    val coctailListPresenter = CoctailListPresenter()
    private val compositeDisposable = CompositeDisposable()

    class CoctailListPresenter : ICoctailListPresenter {

        val coctails = mutableListOf<Coctail>()

        override var itemClickListener: ((ICoctailItemView) -> Unit)? = null

        override fun bindView(view: ICoctailItemView) {
            view.setName(coctails[view.pos].name)
            view.setImage(coctails[view.pos].image)
        }

        override fun getCount(): Int = coctails.size
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initRvCoctails()
        loadData()

    }

    fun setIsAlco(isAlco: Boolean?) {
        isAlco?.let {
            this.isAlco = isAlco
        }
    }

    private fun loadData() {
        isAlco?.let { it ->
            if (it) {
                val disposable1 =
                    coctailsRepo.getAlcoCoctails()
                        .observeOn(uiScheduler)
                        .subscribe({ apiResult ->
                            coctailListPresenter.coctails.clear()
                            coctailListPresenter.coctails.addAll(apiResult.drinks)
                            viewState.updateCoctailsList()
                        }, { error ->
                            error.message?.let { message ->
                                viewState.showError(message)
                            }
                        })
                compositeDisposable.add(disposable1)
            } else {
                val disposable1 =
                    coctailsRepo.getNonAlcoCoctails()
                        .observeOn(uiScheduler)
                        .subscribe({ apiResult ->
                            coctailListPresenter.coctails.clear()
                            coctailListPresenter.coctails.addAll(apiResult.drinks)
                            viewState.updateCoctailsList()
                        }, { error ->
                            error.message?.let { message ->
                                viewState.showError(message)
                            }
                        })
                compositeDisposable.add(disposable1)
            }
        }
    }

    fun backClicked(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}