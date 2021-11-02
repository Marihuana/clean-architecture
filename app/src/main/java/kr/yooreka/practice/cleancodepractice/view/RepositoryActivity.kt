package kr.yooreka.practice.cleancodepractice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kr.yooreka.practice.cleancodepractice.R
import kr.yooreka.practice.cleancodepractice.adapter.RepositoriesAdapter
import kr.yooreka.practice.cleancodepractice.adapter.SearchAdapter
import kr.yooreka.practice.cleancodepractice.databinding.ActivityRepositoryBinding
import kr.yooreka.practice.cleancodepractice.viewmodel.RepositoryViewModel
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.model.UserVO

@AndroidEntryPoint
class RepositoryActivity : AppCompatActivity() {

    private val viewModel : RepositoryViewModel by viewModels()

    lateinit var binding : ActivityRepositoryBinding
    lateinit var recyclerView: RecyclerView

    var selected : UserVO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selected = intent.getSerializableExtra("user") as UserVO

        binding = DataBindingUtil.setContentView(this, R.layout.activity_repository)
        binding.apply {
            this.viewModel = this@RepositoryActivity.viewModel
            this.lifecycleOwner = this@RepositoryActivity
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
                layoutManager = LinearLayoutManager(this@RepositoryActivity)
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