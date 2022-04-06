package com.a5k.newsapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a5k.newsapi.data.model.News
import com.a5k.newsapi.data.repository.Repository
import com.a5k.newsapi.data.sourceData.RetrofitImp
import com.a5k.newsapi.view.AppState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val liveData = MutableLiveData<AppState>()
    private val scope = CoroutineScope(Dispatchers.IO)
    fun getLiveData() = liveData

    fun getDataListNews() {
        liveData.postValue(AppState.Loading(1))
        val data = Repository(RetrofitImp()).getData()
        scope.launch {
            data.enqueue(object : Callback<News> {
                override fun onResponse(
                    call: Call<News>,
                    response: Response<News>
                ) {
                    when (response.code()) {
                        200 -> {
                            response.body()?.let { liveData.postValue(AppState.Success(it)) }
                        }
                        else -> {
                            liveData.postValue(AppState.Error(Throwable("error load")))
                        }
                    }
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    liveData.postValue(AppState.Error(t))
                }

            })

        }
    }


}