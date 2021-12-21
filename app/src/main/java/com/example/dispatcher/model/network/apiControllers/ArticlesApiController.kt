package com.example.dispatcher.model.network.apiControllers

import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.ApiController
import com.example.dispatcher.model.network.services.ArticlesService
import retrofit2.Callback
import java.util.HashMap

const val ENDPOINT_EVERYTHING = "everything/"

const val API__Q__KEY = "q"
const val API__Q_IN_TITLE__KEY = "qInTitle"
const val API__SOURCES__KEY = "sources"
const val API__DOMAINS__KEY = "domains"
const val API__EXCLUDE_DOMAINS__KEY = "excludeDomains"
const val API__FROM__KEY = "from"
const val API__TO__KEY = "to"
const val API__LANGUAGE__KEY = "language"
const val API__SORT_BY__KEY = "sortBy"
const val API__PAGE_SIZE__KEY = "pageSize"
const val API__PAGE__KEY = "page"

class ArticlesApiController: ApiController<ArticlesService>() {
    override fun getEndpoint(): String {
        return ENDPOINT_EVERYTHING
    }

    override fun getApiClass(): Class<ArticlesService> {
        return ArticlesService::class.java
    }

    fun getArticles(callback: Callback<ArticlesResponse>,
                    q: String? = null,
                    qInTitle: String? = null,
                    sources: String? = null,
                    domains: String? = null,
                    excludeDomains: String? = null,
                    from: String? = null,
                    to: String? = null,
                    language: String? = null,
                    sortBy: String? = null,
                    pageSize: Int? = null,
                    page: Int? = null) {
        val params: MutableMap<String, String> = HashMap()
        when {
            !q.isNullOrEmpty() -> params[API__Q__KEY] = q
            !qInTitle.isNullOrEmpty() -> params[API__Q_IN_TITLE__KEY] = qInTitle
            !sources.isNullOrEmpty() -> params[API__SOURCES__KEY] = sources
            !domains.isNullOrEmpty() -> params[API__DOMAINS__KEY] = domains
            !excludeDomains.isNullOrEmpty() -> params[API__EXCLUDE_DOMAINS__KEY] = excludeDomains
            !from.isNullOrEmpty() -> params[API__FROM__KEY] = from
            !to.isNullOrEmpty() -> params[API__TO__KEY] = to
            !language.isNullOrEmpty() -> params[API__LANGUAGE__KEY] = language
            !sortBy.isNullOrEmpty() -> params[API__SORT_BY__KEY] = sortBy
            pageSize != null -> params[API__PAGE_SIZE__KEY] = "$pageSize"
            page != null -> params[API__PAGE__KEY] = "$page"
        }

        getApi().getArticles(params).enqueue(callback)
    }
}