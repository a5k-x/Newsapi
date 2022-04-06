package com.a5k.newsapi.view

import com.a5k.newsapi.data.model.Articles

sealed class AppState {
    data class Success(val item: List<Articles>) : AppState()
    data class Loading(val process: Int) : AppState()
    data class Error(val e: Throwable) : AppState()
}