package com.geraa1985.mixdrinks.mvp.model.entity.room.cache

import com.geraa1985.mixdrinks.mvp.model.entity.base.Cocktail
import io.reactivex.rxjava3.core.Single

interface ICocktailsCache {
    fun putCocktail(cocktail: Cocktail)
    fun getCocktails(): Single<List<Cocktail>>
    fun getCocktail(id: String): Single<Cocktail>
    fun searchCocktailsByName(name: String): Single<List<Cocktail>>
}