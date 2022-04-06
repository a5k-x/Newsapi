package com.a5k.newsapi.data.repository

import com.a5k.newsapi.data.model.Articles
import com.a5k.newsapi.data.sourceData.IDataSource
import retrofit2.Call

class Repository(private val dataSource: IDataSource):IRepositiry {
    override fun getData(): Call<List<Articles>> {
       return  dataSource.getData()
    }


}