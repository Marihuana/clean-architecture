package kr.yooreka.practice.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.presentation.databinding.ItemRepositoryBinding
import kr.yooreka.practice.presentation.view.viewholder.ReposViewHolder

class RepositoriesAdapter(private val listener : (ReposVO)-> Unit) : PagingDataAdapter<ReposVO, ReposViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        val item = getItem(position)
        if(item != null) holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ReposViewHolder(
            ItemRepositoryBinding.inflate(layoutInflater, parent, false), listener
        )
    }

    companion object{
        private val diffCallback = object : DiffUtil.ItemCallback<ReposVO>(){
            override fun areItemsTheSame(oldItem: ReposVO, newItem: ReposVO): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: ReposVO, newItem: ReposVO): Boolean {
                return (oldItem._id == newItem._id)
            }
        }
    }

}
