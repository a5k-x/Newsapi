package com.a5k.newsapi.data.sourceData

import com.a5k.newsapi.data.model.Articles
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET ("top-headlines")
    fun getListNews(@Query ("sources") sources: String,
    @Query ("apiKey") apiKey:String): Call<List<Articles>>

}