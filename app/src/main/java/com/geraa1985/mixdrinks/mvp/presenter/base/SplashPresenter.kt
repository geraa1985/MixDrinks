package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.view.base.ISplashView
import io.reactivex.rxjava3.core.Completable
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

class SplashPresenter: MvpPresenter<ISplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        timer().subscribe()
    }

   private fun timer() =
        Completable.timer(2, TimeUnit.SECONDS).andThen { viewState.go() }


    fun theEnd() {
        viewState.theEnd()
    }

}