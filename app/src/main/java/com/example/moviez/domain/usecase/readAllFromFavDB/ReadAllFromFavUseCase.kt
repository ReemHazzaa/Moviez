package com.example.moviez.domain.usecase.readAllFromFavDB

import androidx.lifecycle.LiveData
import com.example.moviez.app.entity.FavMovieItem
import com.example.moviez.domain.repo.MoviezRepo
import com.example.moviez.domain.usecase.BaseUseCase
import javax.inject.Inject

class ReadAllFromFavUseCase @Inject constructor(private val moviezRepo: MoviezRepo) :
    BaseUseCase<Any, LiveData<List<FavMovieItem>>>() {

    override suspend fun execute(params: Any): LiveData<List<FavMovieItem>> {
        return moviezRepo.getAllFavMovies()
    }
}