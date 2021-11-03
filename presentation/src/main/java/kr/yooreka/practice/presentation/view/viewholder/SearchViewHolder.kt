package kr.yooreka.practice.presentation.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.presentation.databinding.ItemUserBinding

class SearchViewHolder(
    private val binding : ItemUserBinding,
    private val listener : (UserVO)-> Unit)
    : RecyclerView.ViewHolder(binding.root){

    fun bind(item : UserVO){
        binding.item = item
        binding.root.setOnClickListener {
            listener(item)
        }
    }
}