package com.example.dispatcher.model.network.headlines

import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.headlines.TopHeadlinesConstants.API__HEADLINES_CATEGORY__KEY
import com.example.dispatcher.model.network.headlines.TopHeadlinesConstants.API__HEADLINES_COUNTRY__KEY
import com.example.dispatcher.model.network.headlines.TopHeadlinesConstants.API__HEADLINES_PAGE_SIZE__KEY
import com.example.dispatcher.model.network.headlines.TopHeadlinesConstants.API__HEADLINES_PAGE__KEY
import com.example.dispatcher.model.network.headlines.TopHeadlinesConstants.API__HEADLINES_Q__KEY
import com.example.dispatcher.model.network.headlines.TopHeadlinesConstants.API__HEADLINES_SOURCES__KEY
import com.example.dispatcher.model.network.headlines.TopHeadlinesConstants.ENDPOINT_TOP
import com.example.dispatcher.model.network.manager.ApiController
import retrofit2.Response
import java.util.HashMap

class TopHeadlinesApiController: ApiController<TopHeadlinesApi>() {
    override fun getEndpoint(): String {
        return ENDPOINT_TOP
    }

    override fun getApiClass(): Class<TopHeadlinesApi> {
        return TopHeadlinesApi::class.java
    }

    suspend fun getTopArticles(country: String? = null,
                       category: String? = null,
                       sources: String? = null,
                       q: String? = null,
                       pageSize: Int? = null,
                       page: Int? = null): Response<ArticlesResponse> {
        val params: MutableMap<String, String> = HashMap()
        when {
            !country.isNullOrEmpty() -> params[API__HEADLINES_COUNTRY__KEY] = country
            !category.isNullOrEmpty() -> params[API__HEADLINES_CATEGORY__KEY] = category
            !sources.isNullOrEmpty() -> params[API__HEADLINES_SOURCES__KEY] = sources
            !q.isNullOrEmpty() -> params[API__HEADLINES_Q__KEY] = q
            pageSize != null -> params[API__HEADLINES_PAGE_SIZE__KEY] = "$pageSize"
            page != null -> params[API__HEADLINES_PAGE__KEY] = "$page"
        }

        return getApi().getArticles(params)
    }
}