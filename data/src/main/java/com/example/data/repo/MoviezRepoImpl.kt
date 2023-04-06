package com.example.data.repo

import com.example.data.remote.apiService.MoviezApiService
import com.example.domain.entity.movieDetails.MovieDetailsResponse
import com.example.domain.entity.movieList.MovieListResponse
import com.example.domain.entity.nowPlaying.NowPlayingResponse
import com.example.domain.repo.MoviezRepo

class MoviezRepoImpl(private val moviezApiService: MoviezApiService) : MoviezRepo {
    override suspend fun getTopRated(page: Int): MovieListResponse = moviezApiService.getTopRated(page)

    override suspend fun getNowPlaying(page: Int): NowPlayingResponse =
        moviezApiService.getNowPlaying(page)

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsResponse =
        moviezApiService.getMovieDetails(movieId)

    override suspend fun searchMovieByName(
        page: Int,
        includeAdult: Boolean,
        movieName: String
    ): MovieListResponse = moviezApiService.searchMovieByName(page, includeAdult, movieName)

}

