package com.example.studyproject.model.repository.news

import android.util.Log
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.studyproject.common.CommonUiState
import com.example.studyproject.model.data.NewsData
import com.example.studyproject.utils.network.NetworkModule
import dagger.Binds
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * network
 * retrofit, okhttp ....
 */
class NewsRemoteDataSource @Inject constructor(){

    suspend fun getNewsList() = NetworkModule.getApiService(NewsApi::class.java).getNews()

}