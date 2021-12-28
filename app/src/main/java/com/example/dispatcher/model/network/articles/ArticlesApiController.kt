package com.example.dispatcher.model.network.articles

import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_DOMAINS__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_EXCLUDE_DOMAINS__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_FROM__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_LANGUAGE__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_PAGE_SIZE__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_PAGE__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_Q_IN_TITLE__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_Q__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_SORT_BY__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_SOURCES__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.API__EVERYTHING_TO__KEY
import com.example.dispatcher.model.network.articles.ArticlesApiConstants.ENDPOINT_EVERYTHING
import com.example.dispatcher.model.network.manager.ApiController
import retrofit2.Response
import java.util.HashMap

class ArticlesApiController: ApiController<ArticlesApi>() {
    override fun getEndpoint(): String {
        return ENDPOINT_EVERYTHING
    }

    override fun getApiClass(): Class<ArticlesApi> {
        return ArticlesApi::class.java
    }

    suspend fun getArticles(q: String? = null,
                            qInTitle: String? = null,
                            sources: String? = null,
                            domains: String? = null,
                            excludeDomains: String? = null,
                            from: String? = null,
                            to: String? = null,
                            language: String? = null,
                            sortBy: String? = null,
                            pageSize: Int? = null,
                            page: Int? = null): Response<ArticlesResponse> {
        val params: MutableMap<String, String> = HashMap()
        when {
            !q.isNullOrEmpty() -> params[API__EVERYTHING_Q__KEY] = q
            !qInTitle.isNullOrEmpty() -> params[API__EVERYTHING_Q_IN_TITLE__KEY] = qInTitle
            !sources.isNullOrEmpty() -> params[API__EVERYTHING_SOURCES__KEY] = sources
            !domains.isNullOrEmpty() -> params[API__EVERYTHING_DOMAINS__KEY] = domains
            !excludeDomains.isNullOrEmpty() -> params[API__EVERYTHING_EXCLUDE_DOMAINS__KEY] = excludeDomains
            !from.isNullOrEmpty() -> params[API__EVERYTHING_FROM__KEY] = from
            !to.isNullOrEmpty() -> params[API__EVERYTHING_TO__KEY] = to
            !language.isNullOrEmpty() -> params[API__EVERYTHING_LANGUAGE__KEY] = language
            !sortBy.isNullOrEmpty() -> params[API__EVERYTHING_SORT_BY__KEY] = sortBy
            pageSize != null -> params[API__EVERYTHING_PAGE_SIZE__KEY] = "$pageSize"
            page != null -> params[API__EVERYTHING_PAGE__KEY] = "$page"
        }

        return getApi().getArticles(params)
    }
}