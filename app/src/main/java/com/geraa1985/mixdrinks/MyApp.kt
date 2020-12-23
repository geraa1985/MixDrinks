package com.geraa1985.mixdrinks

import android.app.Application
import com.geraa1985.mixdrinks.di.components.DaggerMainGraph
import com.geraa1985.mixdrinks.di.components.MainGraph

class MyApp: Application() {

    companion object{
        lateinit var instance: MyApp
    }

    lateinit var mainGraph: MainGraph

    override fun onCreate() {
        super.onCreate()
        instance = this

        mainGraph = DaggerMainGraph.builder().build()
    }
}