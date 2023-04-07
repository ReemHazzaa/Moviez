package com.example.moviez.app.entity

import androidx.databinding.library.baseAdapters.BR
import com.example.moviez.R
import com.example.moviez.app.utils.genericadapter.HolderClass
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.viewHolder.SearchItemViewHolder


data class SearchItem(
    val id: Int,
    val title: String,
    val imageUrl: String?,
    val voteAvg: String,
) : Listable {
    override val listItemType: HolderClass =
        HolderClass(SearchItemViewHolder::class.java, R.layout.item_search)
    override val variableId: Int = BR.movie
}
