package com.example.moviez.domain.usecase.searchByName

import com.example.moviez.domain.entity.movieList.MovieListResponse
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class SearchByNameUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<SearchByNameUseCase.Params, MovieListResponse>() {

    data class Params(
        val page: Int,
        val includeAdult: Boolean,
        val movieName: String
    )

    override suspend fun execute(params: Params): MovieListResponse {
        return moviezRepo.searchMovieByName(params.page, params.includeAdult, params.movieName)
    }
}