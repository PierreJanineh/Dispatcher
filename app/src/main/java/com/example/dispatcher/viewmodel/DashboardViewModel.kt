package com.example.dispatcher.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dispatcher.model.Article
import com.example.dispatcher.model.ArticlesResponse
import com.example.dispatcher.model.network.headlines.TopHeadlinesApiController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class DashboardViewModel : ViewModel() {
    val articles: MutableLiveData<ArrayList<Article>> = MutableLiveData()

    init {
        getArticles()
    }

    private fun getArticles() {
        TopHeadlinesApiController()
            .getTopArticles(object: Callback<ArticlesResponse> {
                override fun onResponse(
                    call: Call<ArticlesResponse>,
                    response: Response<ArticlesResponse>) {
                    if (response.isSuccessful && response.body() != null)
                        articles.value = response.body()!!.articles
                }

                override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            }, Locale.getDefault().country)
    }
}