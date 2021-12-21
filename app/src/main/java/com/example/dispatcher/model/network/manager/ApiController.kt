package com.example.dispatcher.model.network.manager

abstract class ApiController<T> {
    var mNetworkManager: NetworkManager = NetworkManager.instance

    fun getApi(controller: ApiController<T> = this): T {
        return mNetworkManager.registerController(controller)
    }

    fun useHome(): Boolean {
        return true
    }

    abstract fun getEndpoint(): String
    abstract fun getApiClass(): Class<T>
}