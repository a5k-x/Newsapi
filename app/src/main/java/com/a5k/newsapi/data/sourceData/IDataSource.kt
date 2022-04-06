package com.a5k.newsapi.data.sourceData

import com.a5k.newsapi.data.model.Articles
import retrofit2.Call

interface IDataSource {
    fun getData():Call<List<Articles>>
}