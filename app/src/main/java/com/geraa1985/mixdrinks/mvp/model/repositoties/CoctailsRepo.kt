package com.geraa1985.mixdrinks.mvp.model.repositoties

import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.mvp.model.api.IApiData
import com.geraa1985.mixdrinks.mvp.model.entity.base.ApiResult
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CoctailsRepo: ICoctailsRepo {

    @Inject
    lateinit var api: IApiData

    init {
        MyApp.instance.mainGraph.inject(this)
    }

    override fun getAlcoCoctails(): Single<ApiResult> =
        api.getAlcohol().subscribeOn(Schedulers.io())

    override fun getNonAlcoCoctails(): Single<ApiResult> =
        api.getNonAlcohol().subscribeOn(Schedulers.io())
}