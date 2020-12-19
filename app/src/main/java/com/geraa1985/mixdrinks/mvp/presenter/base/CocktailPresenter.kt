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
                .subscribe({result ->
                    val cocktail: Cocktail = result.drinks[0]
                    viewState.showName(cocktail.name)
                    cocktail.image?.let { viewState.showPicture(it) }
                    cocktail.ingredient1?.let { viewState.showIngredient1(it) }
                    cocktail.ingredient2?.let { viewState.showIngredient2(it) }
                    cocktail.ingredient3?.let { viewState.showIngredient3(it) }
                    cocktail.ingredient4?.let { viewState.showIngredient4(it) }
                    cocktail.ingredient5?.let { viewState.showIngredient5(it) }
                    cocktail.ingredient6?.let { viewState.showIngredient6(it) }
                    cocktail.ingredient7?.let { viewState.showIngredient7(it) }
                    cocktail.ingredient8?.let { viewState.showIngredient8(it) }
                    cocktail.ingredient9?.let { viewState.showIngredient9(it) }
                    cocktail.ingredient10?.let { viewState.showIngredient10(it) }
                    cocktail.ingredient11?.let { viewState.showIngredient11(it) }
                    cocktail.ingredient12?.let { viewState.showIngredient12(it) }
                    cocktail.ingredient13?.let { viewState.showIngredient13(it) }
                    cocktail.ingredient14?.let { viewState.showIngredient14(it) }
                    cocktail.ingredient15?.let { viewState.showIngredient15(it) }
                    cocktail.measure1?.let { viewState.showMeasure1(it) }
                    cocktail.measure2?.let { viewState.showMeasure2(it) }
                    cocktail.measure3?.let { viewState.showMeasure3(it) }
                    cocktail.measure4?.let { viewState.showMeasure4(it) }
                    cocktail.measure5?.let { viewState.showMeasure5(it) }
                    cocktail.measure6?.let { viewState.showMeasure6(it) }
                    cocktail.measure7?.let { viewState.showMeasure7(it) }
                    cocktail.measure8?.let { viewState.showMeasure8(it) }
                    cocktail.measure9?.let { viewState.showMeasure9(it) }
                    cocktail.measure10?.let { viewState.showMeasure10(it) }
                    cocktail.measure11?.let { viewState.showMeasure11(it) }
                    cocktail.measure12?.let { viewState.showMeasure12(it) }
                    cocktail.measure13?.let { viewState.showMeasure13(it) }
                    cocktail.measure14?.let { viewState.showMeasure14(it) }
                    cocktail.measure15?.let { viewState.showMeasure15(it) }
                    cocktail.category?.let { viewState.showCategory(it) }
                    cocktail.alcoholic?.let { viewState.showAlcoholic(it) }
                    cocktail.glass?.let { viewState.showGlass(it) }
                    cocktail.instructions?.let { viewState.showInstruction(it) }
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