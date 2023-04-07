package com.example.moviez.domain.usecase.nowPlaying

import com.example.moviez.domain.entity.nowPlaying.NowPlayingResponse
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetNowPlayingUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<GetNowPlayingUseCase.Params, NowPlayingResponse>() {

    data class Params(
        val page: Int = 1
    )

    override suspend fun execute(params: Params): NowPlayingResponse {
        return moviezRepo.getNowPlaying(params.page)
    }
}