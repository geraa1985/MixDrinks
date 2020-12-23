package com.geraa1985.mixdrinks.mvp.model.repositoties

import com.geraa1985.mixdrinks.mvp.model.entity.base.Cocktail
import io.reactivex.rxjava3.core.Single

interface ICocktailsRepo {
    fun getAlcoCoctails(): Single<List<Cocktail>>
    fun getNonAlcoCoctails(): Single<List<Cocktail>>
    fun getCocktailById(id: String): Single<Cocktail>
    fun searchCocktailByName(name: String): Single<List<Cocktail>>
    fun putCocktail(cocktail: Cocktail)
}