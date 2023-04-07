package com.example.moviez.domain.usecase.topRated

import com.example.moviez.domain.usecase.BaseUseCase
import com.example.moviez.app.entity.MovieItem
import com.example.moviez.domain.repo.MoviezRepo
import javax.inject.Inject

class GetTopRatedUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<GetTopRatedUseCase.Params, List<MovieItem>>() {

    data class Params(
        val page: Int = 1
    )

    override suspend fun execute(params: Params): List<MovieItem> {
        val result = moviezRepo.getTopRated(params.page)
        return result.results.mapIndexed { index, movie ->
            MovieItem(movie.id, movie.title, movie.poster_path, movie.vote_average.toString())
        }
    }
}