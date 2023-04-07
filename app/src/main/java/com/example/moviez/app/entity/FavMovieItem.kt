package com.example.moviez.app.entity

import androidx.databinding.library.baseAdapters.BR
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviez.R
import com.example.moviez.app.utils.genericadapter.HolderClass
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.viewHolder.TopRatedViewHolder

@Entity(tableName = "favorites_table")
data class FavMovieItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val imageUrl: String,
    val voteAvg: String,
) : Listable {
    override val listItemType: HolderClass =
        HolderClass(TopRatedViewHolder::class.java, R.layout.item_fav)
    override val variableId: Int = BR.favMovie
}
