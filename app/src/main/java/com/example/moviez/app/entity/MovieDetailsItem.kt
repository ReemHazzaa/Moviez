package com.example.moviez.app.entity


data class MovieDetailsItem(
    val id: Int,
    val title: String,
    val overview: String,
    val imageUrl: String,
    val voteAvg: String,
    val voteCount: String,
    val genres: List<MovieGenreItem>,
)
