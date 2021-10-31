package kr.yooreka.practice.cleancodepractice.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imgUrl")
fun loadImage(view: ImageView, url : String){
    Glide.with(view.context)
        .load(url)
        .apply(RequestOptions().fitCenter())
        .into(view)
}