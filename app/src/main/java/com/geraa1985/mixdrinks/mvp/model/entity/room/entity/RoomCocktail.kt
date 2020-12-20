package com.geraa1985.mixdrinks.mvp.model.entity.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomCocktail (
    @PrimaryKey val id: String,
    val name: String,
    val image: String?,
    val tags: String?,
    val category: String?,
    val alcoholic: String?,
    val glass: String?,
    val instructions: String?,
    val ingredient1: String?,
    val ingredient2: String?,
    val ingredient3: String?,
    val ingredient4: String?,
    val ingredient5: String?,
    val ingredient6: String?,
    val ingredient7: String?,
    val ingredient8: String?,
    val ingredient9: String?,
    val ingredient10: String?,
    val ingredient11: String?,
    val ingredient12: String?,
    val ingredient13: String?,
    val ingredient14: String?,
    val ingredient15: String?,
    val measure1: String?,
    val measure2: String?,
    val measure3: String?,
    val measure4: String?,
    val measure5: String?,
    val measure6: String?,
    val measure7: String?,
    val measure8: String?,
    val measure9: String?,
    val measure10: String?,
    val measure11: String?,
    val measure12: String?,
    val measure13: String?,
    val measure14: String?,
    val measure15: String?
)