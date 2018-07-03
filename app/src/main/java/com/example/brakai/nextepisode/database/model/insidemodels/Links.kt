package com.example.brakai.nextepisode.database.model.insidemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links (
        @SerializedName("self")
        var self: Self?,
        @SerializedName("previousepisode")
        var previousepisode: PreviousEpisode?,
        @SerializedName("nextepisode")
        var nextepisode: NextEpisode?
) : Parcelable