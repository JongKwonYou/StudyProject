package com.example.studyproject.model.repository.news

import com.example.studyproject.common.ResponseCallback
import com.example.studyproject.model.data.NewsData
import com.example.studyproject.utils.network.simple.NetworkSimpleResponse
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val localDataSource: NewsLocalDataSource,
    private val remoteDataSource: NewsRemoteDataSource
) {

    suspend fun getNewsList() = remoteDataSource.getNewsList()

    suspend fun getNewsList2(callback : ResponseCallback<NewsData>) = remoteDataSource.getNewsList().onResult(callback)


}