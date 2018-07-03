package com.example.brakai.nextepisode

import android.content.Context
import android.support.multidex.MultiDexApplication

class App : MultiDexApplication(){
    companion object {

        private lateinit var instance: App
        val appContext: Context
            get() = instance.applicationContext

    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}