package com.example.brakai.nextepisode.database.model.insidemodels

import android.net.Uri
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Show (
        @SerializedName("id")
        var id: Int,
        @SerializedName("url")
        var url: Uri?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("type")
        var type: String?,
        @SerializedName("language")
        var language: String?,
        @SerializedName("genres")
        var genres: List<String>?,
        @SerializedName("status")
        var status: String?,
        @SerializedName("runtime")
        var runtime: Int?,
        @SerializedName("premiered")
        var premiered: String?,
        @SerializedName("officialSite")
        var officialSite: Uri?,
        @SerializedName("schedule")
        var schedule: Schedule?,
        @SerializedName("rating")
        var rating: Rating?,
        @SerializedName("weight")
        var weight: Int?,
        @SerializedName("network")
        var network: Network?,
        @SerializedName("webChannel")
        var webChannel: String?,
        @SerializedName("externals")
        var externals: Externals?,
        @SerializedName("image")
        var image: Image?,
        @SerializedName("summary")
        var summary: String?,
        @SerializedName("updated")
        var updated: Long?,
        @SerializedName("_links")
        var _links: Links?
) : Parcelable