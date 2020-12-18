package com.geraa1985.mixdrinks.mvp.model.entity.base

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiResult(
    @Expose val drinks: List<Coctail>
): Parcelable