package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.movieDetails.MovieDetailsResponse
import com.example.domain.entity.movieList.MovieListResponse
import com.example.domain.entity.nowPlaying.NowPlayingResponse
import com.example.domain.repo.MoviezRepo

class MoviezRepoImpl(private val apiService: ApiService) : MoviezRepo {
    override suspend fun getTopRated(page: Int): MovieListResponse = apiService.getTopRated(page)

    override suspend fun getNowPlaying(page: Int): NowPlayingResponse =
        apiService.getNowPlaying(page)

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse =
        apiService.getMovieDetails(movieId)

    override suspend fun searchMovieByName(
        page: Int,
        includeAdult: Boolean,
        movieName: String
    ): MovieListResponse = apiService.searchMovieByName(page, includeAdult, movieName)

}

