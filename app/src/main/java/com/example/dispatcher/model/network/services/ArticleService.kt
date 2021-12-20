package com.example.dispatcher.model.network.services

import com.example.dispatcher.model.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface ArticlesService {
    /*
    Space-only string in [@GET] for avoiding [java.lang.IllegalArgumentException]
                   [Missing either @GET URL or @Url parameter.]
     */
    @GET(" ")
    fun getArticles(@QueryMap params: Map<String, String>): Call<ArticlesResponse>
}