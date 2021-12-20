package com.example.dispatcher.model

import android.app.Application
import com.example.dispatcher.model.network.ApiConstants.Companion.API_AUTH_KEY
import com.example.dispatcher.model.network.ApiConstants.Companion.API_AUTH_VALUE
import com.example.dispatcher.model.network.ApiConstants.Companion.API_BASE_URL
import com.example.dispatcher.model.network.ApiConstants.Companion.API_VERSION
import com.example.dispatcher.model.network.ApiConfig
import com.example.dispatcher.model.network.NetworkManager
import okhttp3.Interceptor.Chain

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        NetworkManager.create(
            ApiConfig
                .Builder(API_BASE_URL)
                .setAuthHeader(API_AUTH_KEY, API_AUTH_VALUE)
                .setVersion(API_VERSION)
                .addInterceptor { chain: Chain ->
                    chain.proceed(chain.request())
                }
                .build()
        )
    }
}