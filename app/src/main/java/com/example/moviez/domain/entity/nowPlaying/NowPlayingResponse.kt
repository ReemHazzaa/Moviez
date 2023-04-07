package com.example.moviez.domain.entity.nowPlaying

import com.example.moviez.domain.entity.Movie

data class NowPlayingResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)