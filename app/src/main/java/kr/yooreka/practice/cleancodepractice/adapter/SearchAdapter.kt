package kr.yooreka.practice.cleancodepractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.yooreka.practice.cleancodepractice.databinding.ItemUserBinding
import kr.yooreka.practice.cleancodepractice.viewholder.SearchViewHolder
import kr.yooreka.practice.domain.model.UserVO

class SearchAdapter(private val listener : (UserVO)-> Unit) : PagingDataAdapter<UserVO, SearchViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = getItem(position)
        if(item != null) holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(
            ItemUserBinding.inflate(layoutInflater, parent, false), listener
        )
    }

    companion object{
        private val diffCallback = object : DiffUtil.ItemCallback<UserVO>(){
            override fun areItemsTheSame(oldItem: UserVO, newItem: UserVO): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: UserVO, newItem: UserVO): Boolean {
                return (oldItem.name == newItem.name) && (oldItem.thumbUrl == newItem.thumbUrl)
            }
        }
    }

}
