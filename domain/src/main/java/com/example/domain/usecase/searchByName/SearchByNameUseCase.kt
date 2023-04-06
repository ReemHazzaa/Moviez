package com.example.domain.usecase.searchByName

import com.example.domain.entity.movieList.MovieListResponse
import com.example.domain.repo.MoviezRepo
import com.example.domain.usecase.BaseUseCase

class SearchByNameUseCase(private val moviezRepo: MoviezRepo) :
    BaseUseCase<SearchByNameUseCase.Params, MovieListResponse>() {

    data class Params(
        val movieName: String
    )

    override suspend fun execute(params: Params): MovieListResponse {
        return moviezRepo.searchMoviesByName(params.movieName)
    }
}