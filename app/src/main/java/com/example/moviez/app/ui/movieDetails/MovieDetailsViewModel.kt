package com.example.moviez.app.ui.movieDetails

import androidx.lifecycle.viewModelScope
import com.example.moviez.app.base.BaseViewModel
import com.example.moviez.app.base.ObserveOnceLiveData
import com.example.moviez.app.entity.MovieDetailsItem
import com.example.moviez.domain.usecase.movieDetails.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: GetMovieDetailsUseCase
) : BaseViewModel() {
    val detailsLiveData: ObserveOnceLiveData<MovieDetailsItem> = ObserveOnceLiveData()

    fun getMovieDetails(id: Int) {
        viewModelScope.launch {
            showProgress()
            detailsLiveData.value =
                movieDetailsUseCase.execute(GetMovieDetailsUseCase.Params(movieId = id))
            hideProgress()
        }
    }
}