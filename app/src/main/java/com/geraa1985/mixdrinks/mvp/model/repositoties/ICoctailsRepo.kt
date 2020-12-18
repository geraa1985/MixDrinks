package com.geraa1985.mixdrinks.mvp.model.repositoties

import com.geraa1985.mixdrinks.mvp.model.entity.base.ApiResult
import io.reactivex.rxjava3.core.Single

interface ICoctailsRepo {
    fun getAlcoCoctails(): Single<ApiResult>
    fun getNonAlcoCoctails(): Single<ApiResult>
}