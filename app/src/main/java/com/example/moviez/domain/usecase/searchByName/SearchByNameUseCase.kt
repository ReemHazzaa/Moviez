package com.example.moviez.domain.usecase.searchByName

import com.example.moviez.app.entity.SearchItem
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class SearchByNameUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<SearchByNameUseCase.Params, List<SearchItem>>() {

    data class Params(
        val page: Int,
        val includeAdult: Boolean,
        val movieName: String
    )

    override suspend fun execute(params: Params): List<SearchItem> {
        val result =
            moviezRepo.searchMovieByName(params.page, params.includeAdult, params.movieName)
        return result.results.map { item ->
            SearchItem(item.id, item.title, item.poster_path, item.vote_average.toString())
        }
    }
}