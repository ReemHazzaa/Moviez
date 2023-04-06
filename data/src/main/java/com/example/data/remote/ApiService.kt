package com.example.data.remote

import com.example.domain.entity.movieDetails.MovieDetailsResponse
import com.example.domain.entity.movieList.MovieListResponse
import com.example.domain.entity.nowPlaying.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int
    ): MovieListResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int
    ): NowPlayingResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): MovieDetailsResponse

    @GET("search/movie")
    suspend fun searchMovieByName(
        @Query("page") page: Int,
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("query") query: String
    ): MovieListResponse
}