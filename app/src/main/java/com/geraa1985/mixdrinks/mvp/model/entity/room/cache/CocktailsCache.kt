package com.geraa1985.mixdrinks.mvp.model.entity.room.cache

import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.mvp.model.entity.base.Cocktail
import com.geraa1985.mixdrinks.mvp.model.entity.room.db.AppDB
import com.geraa1985.mixdrinks.mvp.model.entity.room.entity.RoomCocktail
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CocktailsCache : ICocktailsCache {

    @Inject
    lateinit var db: AppDB

    init {
        MyApp.instance.mainGraph.inject(this)
    }

    override fun putCocktail(cocktail: Cocktail) {
        val roomCocktail = cocktail.let {
            RoomCocktail(
                it.id,
                it.name,
                it.image,
                it.tags,
                it.category,
                it.alcoholic,
                it.glass,
                it.instructions,
                it.ingredient1,
                it.ingredient2,
                it.ingredient3,
                it.ingredient4,
                it.ingredient5,
                it.ingredient6,
                it.ingredient7,
                it.ingredient8,
                it.ingredient9,
                it.ingredient10,
                it.ingredient11,
                it.ingredient12,
                it.ingredient13,
                it.ingredient14,
                it.ingredient15,
                it.measure1,
                it.measure2,
                it.measure3,
                it.measure4,
                it.measure5,
                it.measure6,
                it.measure7,
                it.measure8,
                it.measure9,
                it.measure10,
                it.measure11,
                it.measure12,
                it.measure13,
                it.measure14,
                it.measure15
            )
        }
        db.cocktailsDAO.insert(roomCocktail)
    }


    override fun getCocktails(): Single<List<Cocktail>> =
        Single.just(db.cocktailsDAO.getAll().map {
            Cocktail(
                it.id,
                it.name,
                it.image,
                it.tags,
                it.category,
                it.alcoholic,
                it.glass,
                it.instructions,
                it.ingredient1,
                it.ingredient2,
                it.ingredient3,
                it.ingredient4,
                it.ingredient5,
                it.ingredient6,
                it.ingredient7,
                it.ingredient8,
                it.ingredient9,
                it.ingredient10,
                it.ingredient11,
                it.ingredient12,
                it.ingredient13,
                it.ingredient14,
                it.ingredient15,
                it.measure1,
                it.measure2,
                it.measure3,
                it.measure4,
                it.measure5,
                it.measure6,
                it.measure7,
                it.measure8,
                it.measure9,
                it.measure10,
                it.measure11,
                it.measure12,
                it.measure13,
                it.measure14,
                it.measure15
            )
        }).subscribeOn(Schedulers.io())


    override fun getCocktail(id: String): Single<Cocktail> =
        Single.just(db.cocktailsDAO.getCocktail(id).let {
            Cocktail(
                it.id,
                it.name,
                it.image,
                it.tags,
                it.category,
                it.alcoholic,
                it.glass,
                it.instructions,
                it.ingredient1,
                it.ingredient2,
                it.ingredient3,
                it.ingredient4,
                it.ingredient5,
                it.ingredient6,
                it.ingredient7,
                it.ingredient8,
                it.ingredient9,
                it.ingredient10,
                it.ingredient11,
                it.ingredient12,
                it.ingredient13,
                it.ingredient14,
                it.ingredient15,
                it.measure1,
                it.measure2,
                it.measure3,
                it.measure4,
                it.measure5,
                it.measure6,
                it.measure7,
                it.measure8,
                it.measure9,
                it.measure10,
                it.measure11,
                it.measure12,
                it.measure13,
                it.measure14,
                it.measure15
            )
        }).subscribeOn(Schedulers.io())


    override fun searchCocktailsByName(name: String): Single<List<Cocktail>> =
        Single.just(db.cocktailsDAO.searchCocktailsByName(name).map {
            Cocktail(
                it.id,
                it.name,
                it.image,
                it.tags,
                it.category,
                it.alcoholic,
                it.glass,
                it.instructions,
                it.ingredient1,
                it.ingredient2,
                it.ingredient3,
                it.ingredient4,
                it.ingredient5,
                it.ingredient6,
                it.ingredient7,
                it.ingredient8,
                it.ingredient9,
                it.ingredient10,
                it.ingredient11,
                it.ingredient12,
                it.ingredient13,
                it.ingredient14,
                it.ingredient15,
                it.measure1,
                it.measure2,
                it.measure3,
                it.measure4,
                it.measure5,
                it.measure6,
                it.measure7,
                it.measure8,
                it.measure9,
                it.measure10,
                it.measure11,
                it.measure12,
                it.measure13,
                it.measure14,
                it.measure15
            )
        }).subscribeOn(Schedulers.io())

}