package com.example.dispatcher.model.network.manager

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.lang.reflect.Modifier

class NetworkManager private constructor() {

    fun <T> registerController(controller: ApiController<T>): T {
        return getBaseApi(controller.getEndpoint(), controller.useHome()).create(controller.getApiClass())
    }

    private fun getBaseApi(endpoint: String, useHome: Boolean): Retrofit {
        val headerInterceptor = Interceptor { chain: Chain ->
            val builder = chain
                .request()
                .newBuilder()
            if (apiConfig.authHeaderKey != null) {
                builder.addHeader(
                    apiConfig.authHeaderKey!!,
                    apiConfig.authHeaderValue!!
                )
            }
            chain.proceed(builder.build())
        }

        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(headerInterceptor)
        if (apiConfig.interceptors != null) {
            for (interceptor in apiConfig.interceptors!!) {
                okHttpBuilder.addInterceptor(interceptor)
            }
        }

        val client = okHttpBuilder.build()
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder
            .serializeNulls()
            .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create()
        val builder = Retrofit.Builder()

        var baseEndpoint = endpoint
        if (useHome) baseEndpoint = apiConfig.baseUrl + apiConfig.version + endpoint
        builder.baseUrl(baseEndpoint)

        return builder
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    companion object {

        var instance: NetworkManager = NetworkManager()
            private set

        private lateinit var apiConfig: ApiConfig

        fun create(apiConfig: ApiConfig) {
            Companion.apiConfig = apiConfig
        }
    }
}
