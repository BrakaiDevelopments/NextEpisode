package com.example.brakai.nextepisode.database.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "settings")
data class Settings (
        var areNotificationsEnabled : Boolean,
        var isAutoLoginEnabled : Boolean
) : Parcelable