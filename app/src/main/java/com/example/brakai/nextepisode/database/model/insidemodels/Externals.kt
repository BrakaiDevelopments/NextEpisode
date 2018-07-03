package com.example.brakai.nextepisode.database.model.insidemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Externals (
    @SerializedName("tvrage")
    var tvrage: String?,
    @SerializedName("thetvdb")
    var thetvdb: String?,
    @SerializedName("imdb")
    var imdb: String?
) : Parcelable
