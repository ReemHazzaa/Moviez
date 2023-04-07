package com.example.moviez.domain.usecase.movieDetails

import com.example.moviez.app.entity.MovieDetailsItem
import com.example.moviez.app.entity.MovieGenreItem
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<GetMovieDetailsUseCase.Params, MovieDetailsItem>() {

    data class Params(
        val movieId: Int
    )

    override suspend fun execute(params: Params): MovieDetailsItem {
        val result = moviezRepo.getMovieDetails(params.movieId)
        return MovieDetailsItem(
            id = result.id,
            title = result.title,
            overview = result.overview,
            imageUrl = result.poster_path,
            voteAvg = result.vote_average?.toString() ?: "",
            voteCount = result.vote_count?.toString() ?: "",
            genres = result.genres.map { item ->
                MovieGenreItem(item.name)
            }
        )
    }
}