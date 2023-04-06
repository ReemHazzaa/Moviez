package com.example.domain.usecase.topRated

import com.example.domain.entity.movieList.MovieListResponse
import com.example.domain.repo.MoviezRepo
import com.example.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetTopRatedUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<GetTopRatedUseCase.Params, MovieListResponse>() {

    data class Params(
        val page: Int = 1
    )

    override suspend fun execute(params: Params): MovieListResponse {
        return moviezRepo.getTopRated(params.page)
    }
}