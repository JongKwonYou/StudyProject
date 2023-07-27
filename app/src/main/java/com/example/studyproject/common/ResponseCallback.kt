package com.example.studyproject.common

class ResponseCallback<T>(val onSuccess: (T) -> Unit, val onFailed: (Int, String) -> Unit)