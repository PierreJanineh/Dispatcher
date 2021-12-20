package com.example.dispatcher.model.network

import okhttp3.Interceptor

class ApiConfig private constructor(val baseUrl: String) {
    var version: String? = null
    var authHeaderKey: String? = null
    var authHeaderValue: String? = null
    var interceptors: List<Interceptor>? = null

    class Builder(private val baseUrl: String) {
        private var version: String? = null
        private var authHeaderKey: String? = null
        private var authHeaderValue: String? = null
        private val interceptors: MutableList<Interceptor> = ArrayList()

        fun setVersion(version: String?): Builder {
            this.version = version
            return this
        }

        fun setAuthHeader(key: String?, value: String?): Builder {
            authHeaderKey = key
            authHeaderValue = value
            return this
        }

        fun addInterceptor(interceptor: Interceptor): Builder {
            interceptors.add(interceptor)
            return this
        }

        fun build(): ApiConfig {
            val apiConfig = ApiConfig(baseUrl)
            if (version != null) apiConfig.version = version
            if (authHeaderKey != null) {
                apiConfig.authHeaderKey = authHeaderKey
                apiConfig.authHeaderValue = authHeaderValue
            }
            apiConfig.interceptors = interceptors
            return apiConfig
        }
    }
}