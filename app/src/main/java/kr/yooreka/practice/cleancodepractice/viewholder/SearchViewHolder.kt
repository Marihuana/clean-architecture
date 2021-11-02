package kr.yooreka.practice.cleancodepractice.viewholder

import androidx.recyclerview.widget.RecyclerView
import kr.yooreka.practice.cleancodepractice.databinding.ItemUserBinding
import kr.yooreka.practice.domain.model.UserVO

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