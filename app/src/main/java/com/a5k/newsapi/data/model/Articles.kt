package com.a5k.newsapi.data.model

import android.provider.ContactsContract

data class Articles(
    val author:String,
    val title:String,
    val description:String,
    val url:String,
    val urlToImage:String,
    val publishedAt: ContactsContract.Data,
    val content:String
)
