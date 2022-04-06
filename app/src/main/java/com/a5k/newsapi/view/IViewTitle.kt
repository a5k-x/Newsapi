package com.a5k.newsapi.view

import com.a5k.newsapi.data.model.NewsItem

interface IViewTitle {

    fun setHomeUp(boolean: Boolean)
    fun toItemNews(news: NewsItem)
    fun setTitle(title:String)
}