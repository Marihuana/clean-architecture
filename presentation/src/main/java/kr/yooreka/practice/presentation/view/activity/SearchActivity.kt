package kr.yooreka.practice.presentation.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.presentation.R
import kr.yooreka.practice.presentation.databinding.ActivitySearchBinding
import kr.yooreka.practice.presentation.view.adapter.SearchAdapter
import kr.yooreka.practice.presentation.viewmodel.SearchViewModel

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val viewModel : SearchViewModel by viewModels()

    lateinit var binding : ActivitySearchBinding
    lateinit var recyclerView: RecyclerView

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
        recyclerView = binding.rvUser.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = SearchAdapter(::onItemClicked)
        }

        binding.etSearch.setOnEditorActionListener { _, action, _ ->
            if(action == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.search()
                true
            } else false
        }
    }

    private fun bind(){
        viewModel.items.observe(this){
            (recyclerView.adapter as SearchAdapter).submitData(this.lifecycle, it)
        }
    }

    private fun onItemClicked(item : UserVO){
        Intent(this@SearchActivity, DetailActivity::class.java)
            .apply { putExtra("user", item) }
            .run {
                startActivity(this)
            }
    }
}