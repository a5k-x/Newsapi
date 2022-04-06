package com.a5k.newsapi.data.repository

import com.a5k.newsapi.data.model.News
import retrofit2.Call

interface IRepository {
    fun getData(): Call<News>
}