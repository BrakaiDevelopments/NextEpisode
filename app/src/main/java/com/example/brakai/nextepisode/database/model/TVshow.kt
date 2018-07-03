package com.example.brakai.nextepisode.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.brakai.nextepisode.database.model.insidemodels.Show
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tv_shows")
data class TVshow(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("score")
    var score: Float,
    @SerializedName("show")
    var show: Show

): Parcelable