package com.example.dispatcher.model.network.articles

import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ArticlesApi {
    @GET(END_POINT)
    fun getArticles(@QueryMap params: Map<String, String>): Response<ArticlesResponse>
}