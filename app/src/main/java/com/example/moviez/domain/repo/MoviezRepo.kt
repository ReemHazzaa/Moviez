package com.example.moviez.domain.repo

import androidx.lifecycle.LiveData
import com.example.moviez.app.entity.FavMovieItem
import com.example.moviez.domain.entity.movieDetails.MovieDetailsResponse
import com.example.moviez.domain.entity.movieList.MovieListResponse
import com.example.moviez.domain.entity.nowPlaying.NowPlayingResponse

interface MoviezRepo {
    suspend fun getTopRated(page: Int): MovieListResponse

    suspend fun getNowPlaying(page: Int): NowPlayingResponse

    suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse

    suspend fun searchMovieByName(
        page: Int,
        includeAdult: Boolean,
        movieName: String
    ): MovieListResponse

    suspend fun getAllFavMovies() : LiveData<List<FavMovieItem>>

    suspend fun insertFavItem(item: FavMovieItem)

    suspend fun deleteFavItem(item: FavMovieItem)
}