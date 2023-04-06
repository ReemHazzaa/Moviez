package com.example.domain.usecase.nowPlaying

import com.example.domain.entity.nowPlaying.NowPlayingResponse
import com.example.domain.repo.MoviezRepo
import com.example.domain.usecase.BaseUseCase
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