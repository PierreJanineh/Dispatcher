package com.example.dispatcher.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val title: String?,
    val imageUrl: String?,
    val author: String?,
    val body: String?
): Parcelable