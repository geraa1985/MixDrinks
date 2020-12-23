package com.geraa1985.mixdrinks.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geraa1985.mixdrinks.mvp.model.entity.room.entity.RoomCocktail

@Dao
interface ICocktailsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cocktail: RoomCocktail)

    @Query("SELECT * FROM RoomCocktail")
    fun getAll(): List<RoomCocktail>

    @Query("SELECT * FROM RoomCocktail WHERE id = :id LIMIT 1")
    fun getCocktail(id: String): RoomCocktail

    @Query("SELECT * FROM RoomCocktail WHERE name LIKE '%' || :name  || '%'")
    fun searchCocktailsByName(name: String): List<RoomCocktail>

}