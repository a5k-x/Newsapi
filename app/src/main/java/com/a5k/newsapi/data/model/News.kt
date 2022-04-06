package com.a5k.newsapi.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsItem>
) : Parcelable

@Parcelize
data class NewsItem(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) : Parcelable

@Parcelize
data class Source(
    val id: String,
    val name: String
) : Parcelable
