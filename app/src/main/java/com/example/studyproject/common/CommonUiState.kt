package com.example.studyproject.common

sealed class CommonUiState<T>{
    data class Success<T>(val data: T): CommonUiState<T>()
    data class Error<T>(val code: Int, val msg:String) : CommonUiState<T>()
}