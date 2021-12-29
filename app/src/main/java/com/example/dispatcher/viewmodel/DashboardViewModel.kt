package com.example.dispatcher.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dispatcher.model.Article
import com.example.dispatcher.model.network.headlines.TopHeadlinesApiController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class DashboardViewModel : ViewModel() {
    val articles: MutableLiveData<ArrayList<Article>> = MutableLiveData()

    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = TopHeadlinesApiController().getTopArticles(Locale.getDefault().country)
                if (response.isSuccessful && response.body() != null)
                    articles.postValue(response.body()!!.articles)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}