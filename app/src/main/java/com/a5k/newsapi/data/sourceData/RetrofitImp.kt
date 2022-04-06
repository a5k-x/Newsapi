package com.a5k.newsapi.data.sourceData

import com.a5k.newsapi.data.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImp : IDataSource {

    override fun getData(): Call<News> {
        return getService().getListNews(SOURCES, API_KEY)
    }

    private fun getService(): ApiService {
        return retrofit().create(ApiService::class.java)
    }

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"
        private const val API_KEY = "81157a2f01a44e678c326c7ab2945fde"
        private const val SOURCES = "techcrunch"

    }


}