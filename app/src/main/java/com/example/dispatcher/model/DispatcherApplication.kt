package com.example.dispatcher.model

import android.app.Application
import com.example.dispatcher.model.network.ApiConstants.Companion.API_AUTH_KEY
import com.example.dispatcher.model.network.ApiConstants.Companion.API_AUTH_VALUE
import com.example.dispatcher.model.network.ApiConfig
import com.example.dispatcher.model.network.NetworkManager

const val API_BASE_URL = "https://newsapi.org/"
const val API_VERSION = "v2/"

class DispatcherApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        NetworkManager.create(
            ApiConfig
                .Builder(API_BASE_URL)
                .setAuthHeader(API_AUTH_KEY, API_AUTH_VALUE)
                .setVersion(API_VERSION)
                .build()
        )
    }
}