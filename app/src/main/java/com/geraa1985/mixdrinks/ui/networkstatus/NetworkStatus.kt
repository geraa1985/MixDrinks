package com.geraa1985.mixdrinks.ui.networkstatus

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.mvp.model.networkstatus.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject

class NetworkStatus: INetworkStatus {

    private val networkStatus: BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)

    init {
        val connectivityManager =
            MyApp.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val request = NetworkRequest.Builder().build()
        connectivityManager.registerNetworkCallback(
            request,
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    networkStatus.onNext(true)
                }

                override fun onUnavailable() {
                    networkStatus.onNext(false)
                }

                override fun onLost(network: Network) {
                    networkStatus.onNext(false)
                }
            })
    }

    override fun isOnlineSingle(): Single<Boolean> = networkStatus.first(false)

}