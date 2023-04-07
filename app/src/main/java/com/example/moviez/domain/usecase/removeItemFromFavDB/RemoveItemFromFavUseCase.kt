package com.example.moviez.domain.usecase.removeItemFromFavDB

import com.example.moviez.app.entity.FavMovieItem
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class RemoveItemFromFavUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<RemoveItemFromFavUseCase.Params, Any>() {

    data class Params(
        val favMovieItem: FavMovieItem
    )

    override suspend fun execute(params: Params): Any {
        return moviezRepo.deleteFavItem(params.favMovieItem)
    }
}