package com.example.brakai.nextepisode.database.model.insidemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rating(
        @SerializedName("average")
        var average: Float?
):Parcelable