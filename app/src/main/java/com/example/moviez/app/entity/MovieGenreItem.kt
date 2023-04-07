package com.example.moviez.app.entity

import androidx.databinding.library.baseAdapters.BR
import com.example.moviez.R
import com.example.moviez.app.utils.genericadapter.HolderClass
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.viewHolder.GenreViewHolder
import com.example.moviez.app.viewHolder.SearchItemViewHolder


data class MovieGenreItem(
    val name: String
) : Listable {
    override val listItemType: HolderClass =
        HolderClass(GenreViewHolder::class.java, R.layout.item_genre)
    override val variableId: Int = BR.genre
}
