package com.example.brakai.nextepisode.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.brakai.nextepisode.App
import com.example.brakai.nextepisode.database.dao.SettingsDao
import com.example.brakai.nextepisode.database.dao.TVshowDao
import com.example.brakai.nextepisode.database.dao.UserDao
import com.example.brakai.nextepisode.database.model.Settings
import com.example.brakai.nextepisode.database.model.TVshow
import com.example.brakai.nextepisode.database.model.User

@Database(entities = [(User::class), (TVshow::class), (Settings::class)], exportSchema = false, version = 1)
abstract class DatabaseManager : RoomDatabase() {

    private object Holder {
        val INSTANCE = Room.databaseBuilder(App.appContext, DatabaseManager::class.java, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    abstract fun userDao(): UserDao
    abstract fun settings(): SettingsDao
    abstract fun tvshow(): TVshowDao

    companion object {
        val DATABASE_NAME = "NextEpisode"
        val shared: DatabaseManager by lazy { Holder.INSTANCE }
    }
}