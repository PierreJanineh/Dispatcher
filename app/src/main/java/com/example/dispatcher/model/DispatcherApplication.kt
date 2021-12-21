package com.example.dispatcher.model

import android.app.Application
import com.example.dispatcher.BuildConfig.*
import com.example.dispatcher.model.network.ApiConfig
import com.example.dispatcher.model.network.NetworkManager

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