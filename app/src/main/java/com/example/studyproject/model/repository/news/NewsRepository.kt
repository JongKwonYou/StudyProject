package com.example.studyproject.model.repository.news

import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val localDataSource: NewsLocalDataSource,
    private val remoteDataSource: NewsRemoteDataSource
) {

    fun getNewsList(){
        remoteDataSource.getNewsList()
    }
}