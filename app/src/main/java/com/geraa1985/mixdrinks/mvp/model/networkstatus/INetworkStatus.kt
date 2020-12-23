package com.geraa1985.mixdrinks.mvp.model.networkstatus

import io.reactivex.rxjava3.core.Single

interface INetworkStatus {
    fun isOnlineSingle(): Single<Boolean>
}