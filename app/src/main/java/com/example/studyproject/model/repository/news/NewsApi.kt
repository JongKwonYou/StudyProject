package com.example.studyproject.model.repository.news

import com.example.studyproject.model.data.NewsData
import com.example.studyproject.utils.network.simple.NetworkSimpleResponse
import dagger.Module
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject


interface NewsApi {

    @GET("todos/1")
    suspend fun getNews(
//        @Query("GUBUN") GUBUN: String,
//        @Query("USER_ID") USER_ID: String
    ): NetworkSimpleResponse<NewsData>

}