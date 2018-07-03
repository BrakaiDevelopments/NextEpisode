package com.example.brakai.nextepisode.extensions

import com.example.kbrakai.nextepisode.BuildConfig

fun Exception.printOnlyDebug() {
    if (BuildConfig.DEBUG) {
        this.printStackTrace()
    }
}