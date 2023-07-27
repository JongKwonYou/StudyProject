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

    private var instance: Retrofit? = null

    fun init(url: String) {
        instance = null
        this.baseUrl = url
    }

    // 기본적으로 baseUrl 1개로 사용, 다른 url 사용해야할 경우 새로 객체 생성 후 사용할 것
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

    // base url 를 사용하지 않을 경우 새로운 서비스 객체 생성
    fun getRetrofit(url : String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    @Provides
    fun <T> getApiService(service: Class<T>): T {
        return getRetrofit().create(service)
    }
}