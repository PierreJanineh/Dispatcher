package com.example.dispatcher.model.network.apiControllers

import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.ApiConstants.Companion.API_SEARCH_KEYWORD_KEY
import com.example.dispatcher.model.network.ApiConstants.Companion.ENDPOINT_EVERYTHING
import com.example.dispatcher.model.network.ApiController
import com.example.dispatcher.model.network.services.ArticlesService
import retrofit2.Callback
import java.util.HashMap

class ArticlesApiController: ApiController<ArticlesService>() {
    override fun getEndpoint(): String {
        return ENDPOINT_EVERYTHING
    }

    override fun getApiClass(): Class<ArticlesService> {
        return ArticlesService::class.java
    }

    fun getArticles(callback: Callback<ArticlesResponse>, searchKeyword: String = "k") {
        val params: MutableMap<String, String> = HashMap()
        params[API_SEARCH_KEYWORD_KEY] = searchKeyword

        getApi().getArticles(params).enqueue(callback)
    }
}