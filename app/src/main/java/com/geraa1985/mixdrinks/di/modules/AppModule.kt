package com.geraa1985.mixdrinks.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

@Module
class AppModule {

    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

}