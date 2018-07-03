package com.example.brakai.nextepisode.database.dao

import androidx.room.*
import com.example.brakai.nextepisode.database.model.Settings

@Dao
interface SettingsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(settings: Settings)

    @Update
    fun updateMultiple(settings: Settings)

    @Query("DELETE FROM settings")
    fun deleteAll(): Int

}