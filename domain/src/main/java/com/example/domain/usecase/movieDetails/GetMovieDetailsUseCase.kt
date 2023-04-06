package com.example.domain.usecase.movieDetails

import com.example.domain.entity.movieDetails.MovieDetailsResponse
import com.example.domain.repo.MoviezRepo
import com.example.domain.usecase.BaseUseCase

class GetMovieDetailsUseCase(private val moviezRepo: MoviezRepo) :
    BaseUseCase<GetMovieDetailsUseCase.Params, MovieDetailsResponse>() {

    data class Params(
        val movieId: Int
    )

    override suspend fun execute(params: Params): MovieDetailsResponse {
        return moviezRepo.getMovieDetails(params.movieId)
    }
}