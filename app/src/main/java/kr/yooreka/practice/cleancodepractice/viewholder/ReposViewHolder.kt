package kr.yooreka.practice.cleancodepractice.viewholder

import androidx.recyclerview.widget.RecyclerView
import kr.yooreka.practice.cleancodepractice.databinding.ItemRepositoryBinding
import kr.yooreka.practice.domain.model.ReposVO

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