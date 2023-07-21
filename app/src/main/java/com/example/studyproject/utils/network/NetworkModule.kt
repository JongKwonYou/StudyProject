package com.example.studyproject.utils.network

import com.example.studyproject.utils.network.simple.NetworkSimpleResponseAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@Module
@InstallIn(ActivityComponent::class)
object NetworkModule {

    private var baseUrl = "";

    // todo 사용 url이 2개 이상일 경우 처리 ( map 형식 사용 ? )
    private var instance: Retrofit? = null

    fun init(url: String) {
        instance = null
        this.baseUrl = url
    }

//    @Provides
    private fun getRetrofit(): Retrofit {
        return if (instance != null) {
            instance!!
        } else {
            instance = Retrofit.Builder()
                .baseUrl(baseUrl)
                //                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(NetworkResponseAdapterFactory()) // success, ( api & network & unknown ) error
                .addCallAdapterFactory(NetworkSimpleResponseAdapterFactory()) // success, failed
                .build()
            instance!!
        }
    }

//    @Provides
    fun <T> getApiService(service: Class<T>): T {
        return getRetrofit().create(service)
    }
}