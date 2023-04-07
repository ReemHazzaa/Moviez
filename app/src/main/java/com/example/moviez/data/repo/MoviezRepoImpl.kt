package com.example.moviez.data.repo

import com.example.moviez.data.remote.apiService.MoviezApiService
import com.example.moviez.domain.entity.movieDetails.MovieDetailsResponse
import com.example.moviez.domain.entity.movieList.MovieListResponse
import com.example.moviez.domain.entity.nowPlaying.NowPlayingResponse
import com.example.moviez.domain.repo.MoviezRepo
import javax.inject.Inject

class MoviezRepoImpl @Inject constructor(private val moviezApiService: MoviezApiService) :
    MoviezRepo {
    override suspend fun getTopRated(page: Int): MovieListResponse =
        moviezApiService.getTopRated(page)

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

