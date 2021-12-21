package com.example.dispatcher.model.network.headlines

import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.headlines.TopHeadlinesConstants.END_POINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TopHeadlinesApi {
    @GET(END_POINT)
    fun getTopArticles(@QueryMap params: Map<String, String>): Call<ArticlesResponse>
}