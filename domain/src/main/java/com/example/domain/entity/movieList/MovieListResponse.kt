package com.example.domain.entity.movieList

import com.example.domain.entity.Movie

data class MovieListResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)