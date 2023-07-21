package com.example.studyproject.model.repository.news

import android.util.Log
import com.example.studyproject.utils.network.NetworkModule
import dagger.Binds
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * network
 * retrofit, okhttp ....
 */
class NewsRemoteDataSource @Inject constructor(){

    fun getNewsList(){

        GlobalScope.launch {

            NetworkModule.getApiService(NewsApi::class.java).getNews().onResult({
                // todo - add callback
                Log.d("#####","response : ${it.toString()}")
            }, { code, msg ->
                Log.d("######","$code - $msg")
            })

        }
    }

}