package kr.yooreka.practice.cleancodepractice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.yooreka.practice.cleancodepractice.R
import kr.yooreka.practice.cleancodepractice.viewmodel.SearchViewModel

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val viewModel : SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}