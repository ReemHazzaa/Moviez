package com.example.moviez.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviez.R
import com.example.moviez.app.entity.FavMovieItem
import com.example.moviez.app.entity.MovieItem
import com.example.moviez.app.ui.home.HomeFragmentDirections
import com.example.moviez.app.utils.bindingadapters.ImageBindingAdapter.loadImageWithGlide

class FavHomeAdapter :
    RecyclerView.Adapter<FavHomeAdapter.FavMoviesVH>() {

    private var data: List<FavMovieItem> = mutableListOf()

    class FavMoviesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_movie_name)
        val tvRate: TextView = itemView.findViewById(R.id.tv_vote_avg)
        val ivMovie: ImageView = itemView.findViewById(R.id.iv_movie_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMoviesVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fav_home, parent, false)
        return FavMoviesVH(view)
    }

    override fun onBindViewHolder(holder: FavMoviesVH, position: Int) {
        val current = data.get(position)
        holder.apply {
            tvTitle.text = current.title
            tvRate.text = current.voteAvg

            ivMovie.loadImageWithGlide(current.imageUrl)

            itemView.setOnClickListener {
                val itemId = current.id
                val action = HomeFragmentDirections.actionNavigationHomeToMovieDetailsFragment(itemId)
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount(): Int = data.size

    fun setData(list: List<FavMovieItem>) {
        data = list
    }
}