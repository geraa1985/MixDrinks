package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.model.entity.base.Cocktail
import com.geraa1985.mixdrinks.mvp.model.repositoties.ICoctailsRepo
import com.geraa1985.mixdrinks.mvp.view.base.ICocktailView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class CocktailPresenter : MvpPresenter<ICocktailView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var coctailsRepo: ICoctailsRepo

    @Inject
    lateinit var uiScheduler: Scheduler

    private var id: String? = null

    private val compositeDisposable = CompositeDisposable()

    init {
        viewState.setId()
    }

    fun setId(id: String?) {
        id?.let {
            this.id = it
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        id?.let { id ->
            val disposable1 = coctailsRepo.getCocktailById(id)
                .observeOn(uiScheduler)
                .subscribe({
                    val cocktail: Cocktail = it.drinks[0]
                    cocktail.image?.let {image -> viewState.showPicture(image) }
                    viewState.showName(cocktail.name)
                }, {error ->
                    error.message?.let { message ->
                        viewState.showError(message)
                    }
                })
            compositeDisposable.add(disposable1)
        }
    }


    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    fun backClicked(): Boolean {
        router.exit()
        return true
    }
}