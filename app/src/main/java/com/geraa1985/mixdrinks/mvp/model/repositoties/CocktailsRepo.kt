package com.geraa1985.mixdrinks.mvp.model.repositoties

import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.mvp.model.api.IApiData
import com.geraa1985.mixdrinks.mvp.model.entity.base.Cocktail
import com.geraa1985.mixdrinks.mvp.model.entity.room.cache.ICocktailsCache
import com.geraa1985.mixdrinks.mvp.model.networkstatus.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CocktailsRepo : ICocktailsRepo {

    @Inject
    lateinit var api: IApiData

    @Inject
    lateinit var networkStatus: INetworkStatus

    @Inject
    lateinit var cocktailsCache: ICocktailsCache

    init {
        MyApp.instance.mainGraph.inject(this)
    }

    override fun getAlcoCoctails(): Single<List<Cocktail>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getAlcohol().flatMap {
                    Single.just(it.drinks)
                }
            } else {
                cocktailsCache.getCocktails().flatMap { cocktails ->
                    Single.fromCallable {
                        cocktails.filter {
                            return@filter it.alcoholic == "Alcoholic"
                        }
                    }
                }
            }
        }.subscribeOn(Schedulers.io())


    override fun getNonAlcoCoctails(): Single<List<Cocktail>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getNonAlcohol().flatMap {
                    Single.just(it.drinks)
                }
            } else {
                cocktailsCache.getCocktails().flatMap { cocktails ->
                    Single.fromCallable {
                        cocktails.filter {
                            return@filter it.alcoholic == "Non alcoholic"
                        }
                    }
                }
            }
        }.subscribeOn(Schedulers.io())

    override fun getCocktailById(id: String): Single<Cocktail> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getCocktailById(id).flatMap {
                    Single.just(it.drinks[0])
                }
            } else {
                cocktailsCache.getCocktail(id)
            }
        }.subscribeOn(Schedulers.io())

    override fun searchCocktailByName(name: String): Single<List<Cocktail>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.searchCocktailByName(name).flatMap {
                    Single.just(it.drinks)
                }
            } else {
                cocktailsCache.searchCocktailsByName(name)
            }
        }.subscribeOn(Schedulers.io())

    override fun putCocktail(cocktail: Cocktail) {
        cocktailsCache.putCocktail(cocktail)
    }
}