package com.example.studyproject.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyproject.common.CommonUiState
import com.example.studyproject.model.data.NewsData
import com.example.studyproject.model.repository.news.NewsRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel의 경우 ViewModelStoreOwner보다 오래 지속될 수 있으므로 Context 또는 Resources와 같은 수명주기 관련 API 참조를 보유해서는 안된다.
 * test
 */

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _uiState = MutableSharedFlow<CommonUiState<NewsData>>()
    val uiState: SharedFlow<CommonUiState<NewsData>> = _uiState

    init {

        viewModelScope.launch {

//            newsRepository.ru


        }
    }

    companion object {
//        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                val application = checkNotNull(extras)
//            }
//
//
//        }


    }

    fun getNewsList() {
        newsRepository.getNewsList()
    }


}