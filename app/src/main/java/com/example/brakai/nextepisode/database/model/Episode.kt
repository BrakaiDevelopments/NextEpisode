package com.example.brakai.nextepisode.database.model

import android.net.Uri
import android.os.Parcelable
import com.example.brakai.nextepisode.database.model.insidemodels.Links
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Episode (
    @SerializedName("id")
    var id: Int,
    @SerializedName("url")
    var url: Uri?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("season")
    var season: Int?,
    @SerializedName("number")
    var number: Int?,
    @SerializedName("airdate")
    var airdate: String?,
    @SerializedName("airtime")
    var airtime: String?,
    @SerializedName("airstamp")
    var airstamp: String?,
    @SerializedName("runtime")
    var runtime: String?,
    @SerializedName("image")
    var image: Uri?,
    @SerializedName("summary")
    var summary: String?,
    @SerializedName("_links")
    var _links: Links?
) : Parcelable