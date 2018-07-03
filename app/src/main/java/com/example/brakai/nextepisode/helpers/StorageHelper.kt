package com.example.brakai.nextepisode.helpers

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.brakai.nextepisode.App
import com.example.kbrakai.nextepisode.BuildConfig

class StorageHelper private constructor() {

    private object Holder {
        val INSTANCE = StorageHelper()
    }

    companion object {

        private lateinit var mPreferences: SharedPreferences

        private val PREFS_VERSION = "v1"
        private val PRIVATE_MODE = 0
        private val NAME = "${BuildConfig.APPLICATION_ID}_preferences"

        val shared: StorageHelper by lazy { Holder.INSTANCE }

    }

    init {
        mPreferences = App.appContext.getSharedPreferences(NAME, PRIVATE_MODE)
    }

    fun getBoolean(key: String): Boolean {
        return mPreferences.getBoolean(key, false)
    }

    fun getString(key: String): String? {
        return mPreferences.getString(key, null)
    }

    fun getInt(key: String): Int {
        return mPreferences.getInt(key, Integer.MIN_VALUE)
    }

    fun removeValue(key: String) {
        mPreferences.edit {
            remove(key)
        }
    }

    fun storeValue(key: String, value: Any) {
        mPreferences.edit {

            when (value) {
                is Boolean -> {
                    putBoolean(key, value)
                }
                is Int -> {
                    putInt(key, value)
                }
                is String -> {
                    putString(key, value)
                }
            }

        }
    }

}