package com.example.studyproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyproject.common.CommonUiState
import com.example.studyproject.common.ResponseCallback
import com.example.studyproject.model.data.NewsData
import com.example.studyproject.model.repository.news.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel의 경우 ViewModelStoreOwner보다 오래 지속될 수 있으므로 Context 또는 Resources와 같은 수명주기 관련 API 참조를 보유해서는 안된다.
 */

class NewsViewModel @Inject constructor(
    private val scope: CoroutineScope,
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _uiState = MutableSharedFlow<CommonUiState<NewsData>>()
    val uiState: SharedFlow<CommonUiState<NewsData>> = _uiState

    init {

        viewModelScope.launch {

        }
    }

    suspend fun getNewsList() {
        viewModelScope.launch {

                // v1 -> retrofit 통신모듈에 밀접하게 관련되어있어 변경 시 뷰모델이 전부 변경되어야 함
                newsRepository.getNewsList().onResult({

                }, { code, msg ->

                })

                // v2 -> repository단에서 통신을 하고 응답값을 맞춰 전달하기 때문에 결합도 낮아짐
                newsRepository.getNewsList2(ResponseCallback({
                    _uiState.emit(CommonUiState.Success(it))

                }, { code, msg ->

                }))


        }
    }


}