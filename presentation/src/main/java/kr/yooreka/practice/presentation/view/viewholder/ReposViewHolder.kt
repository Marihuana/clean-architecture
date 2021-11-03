package kr.yooreka.practice.presentation.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.presentation.databinding.ItemRepositoryBinding

class ReposViewHolder (
    private val binding : ItemRepositoryBinding,
    private val listener : (ReposVO)-> Unit)
    : RecyclerView.ViewHolder(binding.root){

    fun bind(item : ReposVO){
        binding.item = item
        binding.root.setOnClickListener {
            listener(item)
        }
    }
}