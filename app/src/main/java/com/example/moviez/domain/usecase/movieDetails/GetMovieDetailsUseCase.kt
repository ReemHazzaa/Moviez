package com.example.moviez.domain.usecase.movieDetails

import com.example.moviez.domain.entity.movieDetails.MovieDetailsResponse
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<GetMovieDetailsUseCase.Params, MovieDetailsResponse>() {

    data class Params(
        val movieId: Int
    )

    override suspend fun execute(params: Params): MovieDetailsResponse {
        return moviezRepo.getMovieDetails(params.movieId)
    }
}