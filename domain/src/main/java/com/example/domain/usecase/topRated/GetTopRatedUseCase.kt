package com.example.domain.usecase.topRated

import com.example.domain.repo.MoviezRepo
import com.example.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetTopRatedUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<GetTopRatedUseCase.Params, List<MovieItem>>() {

    data class Params(
        val page: Int = 1
    )

    override suspend fun execute(params: Params): List<MovieItem> {
        val result = moviezRepo.getTopRated(params.page)
        return result.results.mapIndexed { index, movie ->
            MovieItem(movie.id, movie.title, movie.poster_path, movie.vote_average)
        }
    }
}