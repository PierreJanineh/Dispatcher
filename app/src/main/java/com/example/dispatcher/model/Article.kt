package com.example.dispatcher.model

data class Article(
    val title: String?,
    val imageUrl: String?,
    val author: String?,
    val body: String?
)

data class ArticlesResponse(val status: String, val totalResults: Int, val articles: ArrayList<Article>)