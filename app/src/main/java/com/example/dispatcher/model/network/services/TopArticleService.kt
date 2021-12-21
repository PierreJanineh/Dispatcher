package com.example.dispatcher.model.network.services

import com.example.dispatcher.model.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TopArticleService {
    @GET(".")
    fun getTopArticles(@QueryMap params: Map<String, String>): Call<ArticlesResponse>
}