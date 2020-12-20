package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.model.entity.base.Cocktail
import com.geraa1985.mixdrinks.mvp.model.repositoties.ICoctailsRepo
import com.geraa1985.mixdrinks.mvp.presenter.lists.ICocktailListPresenter
import com.geraa1985.mixdrinks.mvp.view.base.IListView
import com.geraa1985.mixdrinks.mvp.view.lists.ICocktailItemView
import com.geraa1985.mixdrinks.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import kotlin.properties.Delegates

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

    private var isAlco by Delegates.notNull<Boolean>()

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
        val disposable1: Disposable
        if (isAlco) {
            disposable1 =
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
        } else {
            disposable1 =
                coctailsRepo.getNonAlcoCoctails()
                    .observeOn(uiScheduler)
                    .subscribe({ apiResult ->
                        coctailListPresenter.coctails.addAll(apiResult.drinks)
                        viewState.updateCoctailsList()
                    }, { error ->
                        error.message?.let { message ->
                            viewState.showError(message)
                        }
                    })
        }
        compositeDisposable.add(disposable1)
    }

    fun searchCocktail(query: String?) {
        query?.let { q ->
            val disposable2 = coctailsRepo.searchCocktailByName(q)
                .flatMap { apiResult ->
                    Single.fromCallable {
                        apiResult.drinks.filter {
                            if (isAlco) {
                                return@filter it.alcoholic == "Alcoholic"
                            } else {
                                return@filter it.alcoholic == "Non alcoholic"
                            }
                        }
                    }
                }
                .observeOn(uiScheduler)
                .subscribe({ drinks ->
                    drinks?.get(0)?.let {
                        router.navigateTo(Screens.cocktailScreen(it.id))
                    }
                }, { error ->
                    error.message?.let { message ->
                        viewState.showError(message)
                    }
                })
            compositeDisposable.add(disposable2)
        }
    }

    fun searchCocktails(newText: String?) {
        newText?.let { text ->
            if (text.isNotEmpty()) {
                val disposable3 = coctailsRepo.searchCocktailByName(text)
                    .flatMap { apiResult ->
                        Single.fromCallable {
                            apiResult.drinks.filter {
                                if (isAlco) {
                                    return@filter it.alcoholic == "Alcoholic"
                                } else {
                                    return@filter it.alcoholic == "Non alcoholic"
                                }
                            }
                        }
                    }
                    .observeOn(uiScheduler)
                    .subscribe({ drinks ->
                        coctailListPresenter.coctails.clear()
                        coctailListPresenter.coctails.addAll(drinks)
                        viewState.updateCoctailsList()
                    }, { error ->
                        error.message?.let { message ->
                            viewState.showError(message)
                        }
                    })
                compositeDisposable.add(disposable3)
            }
        }
    }

    fun searchHint(): String {
        if (isAlco) {
            return "Search alcoholic cocktail"
        }
        return "Search non-alcoholic cocktail"
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