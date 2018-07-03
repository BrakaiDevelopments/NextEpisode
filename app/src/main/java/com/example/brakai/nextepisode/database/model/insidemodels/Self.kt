package com.example.brakai.nextepisode.database.model.insidemodels

import android.net.Uri
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Self (
        @SerializedName("href")
        var href: Uri?
) : Parcelable