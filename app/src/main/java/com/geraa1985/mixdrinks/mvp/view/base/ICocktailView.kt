package com.geraa1985.mixdrinks.mvp.view.base

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ICocktailView : MvpView {
    fun showError(message: String)
    fun setId()
    fun showPicture(url: String)
    fun showName(name: String)
    fun showIngredient1(ingredient: String)
    fun showIngredient2(ingredient: String)
    fun showIngredient3(ingredient: String)
    fun showIngredient4(ingredient: String)
    fun showIngredient5(ingredient: String)
    fun showIngredient6(ingredient: String)
    fun showIngredient7(ingredient: String)
    fun showIngredient8(ingredient: String)
    fun showIngredient9(ingredient: String)
    fun showIngredient10(ingredient: String)
    fun showIngredient11(ingredient: String)
    fun showIngredient12(ingredient: String)
    fun showIngredient13(ingredient: String)
    fun showIngredient14(ingredient: String)
    fun showIngredient15(ingredient: String)
    fun showMeasure1(measure: String)
    fun showMeasure2(measure: String)
    fun showMeasure3(measure: String)
    fun showMeasure4(measure: String)
    fun showMeasure5(measure: String)
    fun showMeasure6(measure: String)
    fun showMeasure7(measure: String)
    fun showMeasure8(measure: String)
    fun showMeasure9(measure: String)
    fun showMeasure10(measure: String)
    fun showMeasure11(measure: String)
    fun showMeasure12(measure: String)
    fun showMeasure13(measure: String)
    fun showMeasure14(measure: String)
    fun showMeasure15(measure: String)
    fun showCategory(categoty: String)
    fun showAlcoholic(alcoholic: String)
    fun showGlass(glass: String)
    fun showInstruction(instruction: String)

}