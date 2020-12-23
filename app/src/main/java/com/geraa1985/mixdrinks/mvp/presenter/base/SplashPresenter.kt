package com.geraa1985.mixdrinks.mvp.presenter.base

import com.geraa1985.mixdrinks.mvp.view.base.ISplashView
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashPresenter: MvpPresenter<ISplashView>() {

    @Inject
    lateinit var uiScheduler: Scheduler

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        timer().subscribe()
    }

   private fun timer() =
        Completable.timer(2, TimeUnit.SECONDS).observeOn(uiScheduler).andThen { viewState.go() }


    fun theEnd() {
        viewState.theEnd()
    }

}