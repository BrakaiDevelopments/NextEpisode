package com.example.brakai.nextepisode.database.model.insidemodels

import android.net.Uri
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image (
        @SerializedName("medium")
        var medium: Uri?,
        @SerializedName("original")
        var original: Uri?
) : Parcelable