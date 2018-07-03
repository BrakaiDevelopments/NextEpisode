package com.example.brakai.nextepisode.database.model

import android.net.Uri
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "users")
class User (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var email: String,
    var displayName: String?,
    var image: Uri?
) : Parcelable