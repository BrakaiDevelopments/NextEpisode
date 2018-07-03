package com.example.brakai.nextepisode.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import com.example.brakai.nextepisode.App

object NetworkHelper {

    fun getNetworkAvailability(): Int {

        // 400 = offline
        // 500 = slow network
        // 200 = ok (fast network)

        val cm = App.appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
                ?: return 400
        val activeNetwork = cm.activeNetworkInfo ?: return 400

        var connectionLevel = 400

        when (activeNetwork.type) {
            ConnectivityManager.TYPE_WIFI -> {
                connectionLevel = 200
            }
            ConnectivityManager.TYPE_MOBILE -> {
                val telManager = App.appContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                connectionLevel = if (telManager.networkType > TelephonyManager.NETWORK_TYPE_GPRS) {
                    200
                } else {
                    500
                }
            }
            ConnectivityManager.TYPE_BLUETOOTH, ConnectivityManager.TYPE_ETHERNET -> {
                connectionLevel = 200
            }
        }

        return if (connectionLevel != 400 && activeNetwork.isAvailable && activeNetwork.isConnected) connectionLevel else 400
    }

    fun hasPhoneNetwork(): Boolean {
        val telephony = App.appContext.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
                ?: return false
        return telephony.phoneType != TelephonyManager.PHONE_TYPE_NONE
    }
}