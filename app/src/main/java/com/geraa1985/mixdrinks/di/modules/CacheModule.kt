package com.geraa1985.mixdrinks.di.modules

import androidx.room.Room
import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.mvp.model.entity.room.cache.CocktailsCache
import com.geraa1985.mixdrinks.mvp.model.entity.room.cache.ICocktailsCache
import com.geraa1985.mixdrinks.mvp.model.entity.room.db.AppDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun db(): AppDB = Room.databaseBuilder(
        MyApp.instance,
        AppDB::class.java,
        AppDB.NAME_DB
    ).build()

    @Singleton
    @Provides
    fun cocktailsCache(): ICocktailsCache = CocktailsCache()


}