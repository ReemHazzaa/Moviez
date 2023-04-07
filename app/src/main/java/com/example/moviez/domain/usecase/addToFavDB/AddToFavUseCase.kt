package com.example.moviez.domain.usecase.addToFavDB

import com.example.moviez.app.entity.FavMovieItem
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class AddToFavUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<AddToFavUseCase.Params, Any>() {

    data class Params(
        val favMovieItem: FavMovieItem
    )

    override suspend fun execute(params: Params): Any {
        return moviezRepo.insertFavItem(params.favMovieItem)
    }
}