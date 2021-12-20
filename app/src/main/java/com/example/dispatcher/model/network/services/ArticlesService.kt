package com.example.dispatcher.model.network.services

import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.ApiConstants.Companion.API_SEARCH_KEYWORD_KEY
import com.example.dispatcher.model.network.ApiConstants.Companion.ENDPOINT_EVERYTHING
import com.example.dispatcher.model.network.ApiController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.QueryMap
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

interface ArticlesService {
    /*
    Space-only string in [@GET] for avoiding [java.lang.IllegalArgumentException]
                   [Missing either @GET URL or @Url parameter.]
     */
    @GET(" ")
    fun getArticles(@QueryMap params: Map<String, String>): Call<ArticlesResponse>
}