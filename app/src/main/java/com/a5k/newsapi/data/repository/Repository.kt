package com.a5k.newsapi.data.repository

import com.a5k.newsapi.data.model.News
import com.a5k.newsapi.data.sourceData.IDataSource
import retrofit2.Call

class Repository(private val dataSource: IDataSource):IRepository {
    override fun getData(): Call<News> {
       return  dataSource.getData()
    }


}