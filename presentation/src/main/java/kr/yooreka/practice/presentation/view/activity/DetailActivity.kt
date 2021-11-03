package kr.yooreka.practice.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.presentation.R
import kr.yooreka.practice.presentation.databinding.ActivityDetailBinding
import kr.yooreka.practice.presentation.view.adapter.RepositoriesAdapter
import kr.yooreka.practice.presentation.viewmodel.DetailViewModel

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val viewModel : DetailViewModel by viewModels()

    lateinit var binding : ActivityDetailBinding
    lateinit var recyclerView: RecyclerView

    var selected : UserVO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selected = intent.getSerializableExtra("user") as UserVO

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.apply {
            this.viewModel = this@DetailActivity.viewModel
            this.lifecycleOwner = this@DetailActivity
            this.user = selected
        }

        init()
        bind()


    }

    private fun init(){
        if(selected == null){
            //empty data
        }else{
            viewModel.getRepositories(selected!!.name)

            recyclerView = binding.rvRepository.apply {
                layoutManager = LinearLayoutManager(this@DetailActivity)
                adapter = RepositoriesAdapter(::onItemClicked)
            }
        }
    }

    private fun bind(){
        viewModel.items.observe(this){
            (recyclerView.adapter as RepositoriesAdapter).submitData(this.lifecycle, it)
        }
    }

    private fun onItemClicked(item : ReposVO){
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
    }
}