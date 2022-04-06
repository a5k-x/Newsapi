package com.a5k.newsapi.data.repository

import com.a5k.newsapi.data.model.Articles
import retrofit2.Call

interface IRepositiry {
    fun getData(): Call<List<Articles>>
}