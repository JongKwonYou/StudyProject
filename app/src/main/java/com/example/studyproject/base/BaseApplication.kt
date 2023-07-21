package com.example.studyproject.base

import android.app.Application
import com.example.studyproject.utils.DLog
import com.example.studyproject.utils.network.NetworkModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    // test server
    private val baseURL = "https://jsonplaceholder.typicode.com/";

    override fun onCreate() {
        super.onCreate()

        DLog.init(this)

        NetworkModule.init(baseURL)
    }

}