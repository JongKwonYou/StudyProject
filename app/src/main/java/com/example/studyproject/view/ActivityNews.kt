package com.example.studyproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.studyproject.databinding.ActivityNewsBinding
import com.example.studyproject.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

// git commit message convention check10
@AndroidEntryPoint
class ActivityNews : AppCompatActivity() {

    private lateinit var mBinding: ActivityNewsBinding

    @Inject
    lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        observing()
        getList()
    }

    private fun observing() {

        lifecycleScope.launch {

            /**
             * StateFlow의 경우 화면 상태와 상관없이 이벤트를 전하기 때문에,
             * repeatOnLifecycle를 사용하여 STARTED 이후상태만 UI를 변경하도록 해야한다.
             * -> UI수정이 필요없고, 생명주기과 관련없다면 repeatOnLifecycle를 사용하지 않아도 됨.
             * ( LiveData는 뷰가 STOPPED 상태가 되면 자동으로 데이터 구독을 취소한다. )
             */
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                // start data observing

            }

        }
    }

    private fun getList(){
        newsViewModel.getNewsList()
    }
}