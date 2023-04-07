package com.example.moviez.app.viewHolder

import androidx.databinding.ViewDataBinding
import com.example.moviez.app.entity.MovieItem
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.utils.genericadapter.listener.OnItemClickCallback
import com.example.moviez.app.utils.genericadapter.viewholder.BaseViewHolder

class TopRatedViewHolder(val binding: ViewDataBinding, onItemClickCallback: OnItemClickCallback) :
    BaseViewHolder(binding, onItemClickCallback) {
    init {
        attachClickListener(binding.root)
    }

    override fun draw(listable: Listable) {
        super.draw(listable)
        val current = listable as MovieItem
    }
}