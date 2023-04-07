package com.example.moviez.app.ui.fav

import com.example.moviez.app.base.BaseViewModel
import com.example.moviez.domain.usecase.readAllFromFavDB.ReadAllFromFavUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor(
    private val readAllFromFavUseCase: ReadAllFromFavUseCase
) : BaseViewModel() {
    suspend fun readAllFav() = readAllFromFavUseCase.execute("")
}