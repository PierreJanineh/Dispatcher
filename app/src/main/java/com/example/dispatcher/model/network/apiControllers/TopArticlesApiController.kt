package com.example.dispatcher.model.network.apiControllers

import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.ApiController
import com.example.dispatcher.model.network.services.TopArticleService
import retrofit2.Callback
import java.util.HashMap

const val ENDPOINT_TOP = "top-headlines/"

const val API__TOP_COUNTRY__KEY = "country"
const val API__TOP_CATEGORY__KEY = "category"
const val API__TOP_SOURCES__KEY = "sources"
const val API__TOP_Q__KEY = "q"
const val API__TOP_PAGE_SIZE__KEY = "pageSize"
const val API__TOP_PAGE__KEY = "page"

class TopArticlesApiController: ApiController<TopArticleService>() {
    override fun getEndpoint(): String {
        return ENDPOINT_TOP
    }

    override fun getApiClass(): Class<TopArticleService> {
        return TopArticleService::class.java
    }

    fun getTopArticles(callback: Callback<ArticlesResponse>,
                       country: String? = null,
                       category: String? = null,
                       sources: String? = null,
                       q: String? = null,
                       pageSize: Int? = null,
                       page: Int? = null){
        val params: MutableMap<String, String> = HashMap()
        when {
            !country.isNullOrEmpty() -> params[API__TOP_COUNTRY__KEY] = country
            !category.isNullOrEmpty() -> params[API__TOP_CATEGORY__KEY] = category
            !sources.isNullOrEmpty() -> params[API__TOP_SOURCES__KEY] = sources
            !q.isNullOrEmpty() -> params[API__TOP_Q__KEY] = q
            pageSize != null -> params[API__TOP_PAGE_SIZE__KEY] = "$pageSize"
            page != null -> params[API__TOP_PAGE__KEY] = "$page"
        }

        getApi().getTopArticles(params).enqueue(callback)
    }
}