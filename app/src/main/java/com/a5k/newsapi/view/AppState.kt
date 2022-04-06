package com.a5k.newsapi.view

import com.a5k.newsapi.data.model.News

sealed class AppState {
    data class Success(val listNews: News) : AppState()
    data class Loading(val process: Int) : AppState()
    data class Error(val e: Throwable) : AppState()
}