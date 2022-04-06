package com.a5k.newsapi.data.sourceData

import com.a5k.newsapi.data.model.Articles
import retrofit2.Call

class RemoveDataSource(private val retrofit:IRetrofitDataSource):IDataSource {
    override fun getData(): Call<List<Articles>> {
       return retrofit.getListNews()
    }
}