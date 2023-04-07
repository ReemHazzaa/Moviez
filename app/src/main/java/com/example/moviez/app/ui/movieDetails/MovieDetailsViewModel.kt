package com.example.moviez.app.ui.movieDetails

import androidx.lifecycle.viewModelScope
import com.example.moviez.app.base.BaseViewModel
import com.example.moviez.app.base.ObserveOnceLiveData
import com.example.moviez.app.entity.FavMovieItem
import com.example.moviez.app.entity.MovieDetailsItem
import com.example.moviez.domain.usecase.addToFavDB.AddToFavUseCase
import com.example.moviez.domain.usecase.movieDetails.GetMovieDetailsUseCase
import com.example.moviez.domain.usecase.readAllFromFavDB.ReadAllFromFavUseCase
import com.example.moviez.domain.usecase.removeItemFromFavDB.RemoveItemFromFavUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: GetMovieDetailsUseCase,
    private val addToFavUseCase: AddToFavUseCase,
    private val readAllFromFavUseCase: ReadAllFromFavUseCase,
    private val removeItemFromFavUseCase: RemoveItemFromFavUseCase
) : BaseViewModel() {
    val detailsLiveData: ObserveOnceLiveData<MovieDetailsItem> = ObserveOnceLiveData()

    fun getMovieDetails(id: Int) {
        viewModelScope.launch(getExceptionHandler()) {
            showProgress()
            detailsLiveData.value =
                movieDetailsUseCase.execute(GetMovieDetailsUseCase.Params(movieId = id))
            hideProgress()
        }
    }

    fun addToFav(favMovieItem: FavMovieItem) =
        viewModelScope.launch(Dispatchers.IO + getExceptionHandler()) {
            addToFavUseCase.execute(AddToFavUseCase.Params(favMovieItem))
        }

    fun removeItemFromFav(favMovieItem: FavMovieItem) =
        viewModelScope.launch(Dispatchers.IO + getExceptionHandler()) {
            removeItemFromFavUseCase.execute(RemoveItemFromFavUseCase.Params(favMovieItem))
        }

    suspend fun readAllFav() = readAllFromFavUseCase.execute("")
}