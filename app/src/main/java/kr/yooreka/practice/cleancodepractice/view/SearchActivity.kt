package kr.yooreka.practice.cleancodepractice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import kr.yooreka.practice.cleancodepractice.R
import kr.yooreka.practice.cleancodepractice.databinding.ActivitySearchBinding
import kr.yooreka.practice.cleancodepractice.viewmodel.SearchViewModel

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val viewModel : SearchViewModel by viewModels()
    lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.apply {
            this.viewModel = this@SearchActivity.viewModel
            this.lifecycleOwner = this@SearchActivity
        }

        init()
        bind()
    }

    private fun init(){
        binding.etSearch.setOnEditorActionListener { _, action, _ ->
            if(action == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.search()
                true
            } else false
        }
    }

    private fun bind(){
        viewModel.selectedUser.observe(this){
            if(it != null){
                Intent(this, RepositoryActivity::class.java)
                    .apply { putExtra("_id", it._id) }
                    .run {
                        startActivity(this)
                    }
            }
        }
    }
}