package com.example.domain.entity.nowPlaying

import com.example.domain.entity.Movie

data class NowPlayingResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)