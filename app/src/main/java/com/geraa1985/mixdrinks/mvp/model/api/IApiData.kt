package com.geraa1985.mixdrinks.mvp.model.api

import com.geraa1985.mixdrinks.mvp.model.entity.base.ApiResult
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiData {

    @GET("filter.php?a=Alcoholic")
    fun getAlcohol(): Single<ApiResult>

    @GET("filter.php?a=Non_Alcoholic")
    fun getNonAlcohol(): Single<ApiResult>

    @GET("lookup.php")
    fun getCocktailById(@Query("i") id: String): Single<ApiResult>

    @GET("search.php?")
    fun searchCocktailByName(@Query("s") name: String): Single<ApiResult>

}