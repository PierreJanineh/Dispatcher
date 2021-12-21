package com.example.dispatcher.model

data class Article(
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val author: String?,
    val body: String?,
    val publishedAt: String?,
    val content: String?,
)

data class ArticlesResponse(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<Article>
)