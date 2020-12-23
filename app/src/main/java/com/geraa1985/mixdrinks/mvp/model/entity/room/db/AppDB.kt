package com.geraa1985.mixdrinks.mvp.model.entity.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geraa1985.mixdrinks.mvp.model.entity.room.dao.ICocktailsDAO
import com.geraa1985.mixdrinks.mvp.model.entity.room.entity.RoomCocktail

@Database(entities = [RoomCocktail::class], version = 1)
abstract class AppDB: RoomDatabase() {

    abstract val cocktailsDAO: ICocktailsDAO

    companion object {
        const val NAME_DB = "database.db"
    }
}