package com.geraa1985.mixdrinks.mvp.model.entity.base

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cocktail(
    @Expose @SerializedName("idDrink") val id: String,
    @Expose @SerializedName("strDrink") val name: String,
    @Expose @SerializedName("strDrinkThumb") val image: String?,
    @Expose @SerializedName("strTags") val tags: String?,
    @Expose @SerializedName("strCategory") val category: String?,
    @Expose @SerializedName("strAlcoholic") val alcoholic: String?,
    @Expose @SerializedName("strGlass") val glass: String?,
    @Expose @SerializedName("strInstructions") val instructions: String?,

    @Expose @SerializedName("strIngredient1") val ingredient1: String?,
    @Expose @SerializedName("strIngredient2") val ingredient2: String?,
    @Expose @SerializedName("strIngredient3") val ingredient3: String?,
    @Expose @SerializedName("strIngredient4") val ingredient4: String?,
    @Expose @SerializedName("strIngredient5") val ingredient5: String?,
    @Expose @SerializedName("strIngredient6") val ingredient6: String?,
    @Expose @SerializedName("strIngredient7") val ingredient7: String?,
    @Expose @SerializedName("strIngredient8") val ingredient8: String?,
    @Expose @SerializedName("strIngredient9") val ingredient9: String?,
    @Expose @SerializedName("strIngredient10") val ingredient10: String?,
    @Expose @SerializedName("strIngredient11") val ingredient11: String?,
    @Expose @SerializedName("strIngredient12") val ingredient12: String?,
    @Expose @SerializedName("strIngredient13") val ingredient13: String?,
    @Expose @SerializedName("strIngredient14") val ingredient14: String?,
    @Expose @SerializedName("strIngredient15") val ingredient15: String?,

    @Expose @SerializedName("strMeasure1") val measure1: String?,
    @Expose @SerializedName("strMeasure2") val measure2: String?,
    @Expose @SerializedName("strMeasure3") val measure3: String?,
    @Expose @SerializedName("strMeasure4") val measure4: String?,
    @Expose @SerializedName("strMeasure5") val measure5: String?,
    @Expose @SerializedName("strMeasure6") val measure6: String?,
    @Expose @SerializedName("strMeasure7") val measure7: String?,
    @Expose @SerializedName("strMeasure8") val measure8: String?,
    @Expose @SerializedName("strMeasure9") val measure9: String?,
    @Expose @SerializedName("strMeasure10") val measure10: String?,
    @Expose @SerializedName("strMeasure11") val measure11: String?,
    @Expose @SerializedName("strMeasure12") val measure12: String?,
    @Expose @SerializedName("strMeasure13") val measure13: String?,
    @Expose @SerializedName("strMeasure14") val measure14: String?,
    @Expose @SerializedName("strMeasure15") val measure15: String?

) : Parcelable