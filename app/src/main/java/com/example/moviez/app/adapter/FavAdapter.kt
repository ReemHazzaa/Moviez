package com.example.moviez.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviez.R
import com.example.moviez.app.entity.FavMovieItem
import com.example.moviez.app.utils.bindingadapters.ImageBindingAdapter.loadImageWithGlide

class FavAdapter :
    RecyclerView.Adapter<FavAdapter.FavMoviesVH>() {

    private var data: List<FavMovieItem> = mutableListOf()

    class FavMoviesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvRate: TextView = itemView.findViewById(R.id.tv_rate)
        val ivMovie: ImageView = itemView.findViewById(R.id.iv_movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMoviesVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fav, parent, false)
        return FavMoviesVH(view)
    }

    override fun onBindViewHolder(holder: FavMoviesVH, position: Int) {
        val current = data.get(position)
        holder.apply {
            tvTitle.text = current.title
            tvRate.text = current.voteAvg

            ivMovie.loadImageWithGlide(current.imageUrl)

            itemView.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int = data.size

    fun setData(list: List<FavMovieItem>) {
        data = list
    }
}