package com.example.moviez.domain.usecase.nowPlaying

import com.example.moviez.app.entity.MovieItem
import com.example.moviez.domain.entity.nowPlaying.NowPlayingResponse
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetNowPlayingUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<GetNowPlayingUseCase.Params, List<MovieItem>>() {

    data class Params(
        val page: Int = 1
    )

    override suspend fun execute(params: Params): List<MovieItem> {
        val result = moviezRepo.getNowPlaying(params.page)
        return result.results.mapIndexed { index, movie ->
            MovieItem(movie.id, movie.title, movie.poster_path, movie.vote_average.toString())
        }
    }
}