package com.example.domain.repo

import com.example.domain.entity.movieDetails.MovieDetailsResponse
import com.example.domain.entity.movieList.MovieListResponse
import com.example.domain.entity.nowPlaying.NowPlayingResponse

interface MoviezRepo {
    suspend fun getTopRated(page: Int): MovieListResponse

    suspend fun getNowPlaying(): NowPlayingResponse

    suspend fun getMovieDetails(): MovieDetailsResponse

    suspend fun searchMoviesByName(): MovieListResponse
}