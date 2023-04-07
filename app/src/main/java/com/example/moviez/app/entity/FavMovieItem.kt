package com.example.moviez.app.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class FavMovieItem(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var title: String,
    var imageUrl: String,
    var voteAvg: String,
)
//    : Listable {
//    override val listItemType: HolderClass =
//        HolderClass(TopRatedViewHolder::class.java, R.layout.item_fav)
//    override val variableId: Int = BR.favMovie
//}
