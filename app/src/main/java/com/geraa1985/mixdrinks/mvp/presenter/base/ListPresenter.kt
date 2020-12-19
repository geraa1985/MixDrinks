package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.model.entity.base.Cocktail
import com.geraa1985.mixdrinks.mvp.model.repositoties.ICoctailsRepo
import com.geraa1985.mixdrinks.mvp.presenter.lists.ICocktailListPresenter
import com.geraa1985.mixdrinks.mvp.view.base.IListView
import com.geraa1985.mixdrinks.mvp.view.lists.ICocktailItemView
import com.geraa1985.mixdrinks.navigation.Screens
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

    val coctailListPresenter = CocktailListPresenter()
    private val compositeDisposable = CompositeDisposable()

    class CocktailListPresenter : ICocktailListPresenter {

        val coctails = mutableListOf<Cocktail>()

        override var itemClickListener: ((ICocktailItemView) -> Unit)? = null

        override fun bindView(view: ICocktailItemView) {
            view.setName(coctails[view.pos].name)
            coctails[view.pos].image?.let { view.setImage(it) }
        }

        override fun getCount(): Int = coctails.size
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initRvCoctails()
        loadData()

        coctailListPresenter.itemClickListener = {
            val id = coctailListPresenter.coctails[it.pos].id
            router.navigateTo(Screens.cocktailScreen(id))
        }
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