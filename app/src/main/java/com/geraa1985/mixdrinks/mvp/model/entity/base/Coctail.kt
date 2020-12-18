package com.geraa1985.mixdrinks.mvp.model.entity.base

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coctail(
    @Expose @SerializedName("idDrink") val id: String,
    @Expose @SerializedName("strDrink") val name: String,
    @Expose @SerializedName("strDrinkThumb") val image: String
) : Parcelable