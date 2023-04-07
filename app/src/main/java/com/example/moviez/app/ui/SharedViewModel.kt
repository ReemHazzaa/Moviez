package com.example.moviez.app.ui

import androidx.lifecycle.viewModelScope
import com.example.moviez.app.base.BaseViewModel
import com.example.moviez.app.base.ObserveOnceLiveData
import com.example.moviez.app.entity.MovieItem
import com.example.moviez.domain.usecase.nowPlaying.GetNowPlayingUseCase
import com.example.moviez.domain.usecase.readAllFromFavDB.ReadAllFromFavUseCase
import com.example.moviez.domain.usecase.topRated.GetTopRatedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val topRatedUseCase: GetTopRatedUseCase,
    private val getNowPlayingUseCase: GetNowPlayingUseCase,
    private val readAllFromFavUseCase: ReadAllFromFavUseCase
) :
    BaseViewModel() {

    val topRatedLiveData = ObserveOnceLiveData<List<MovieItem>>()
    val nowPlayingLiveData = ObserveOnceLiveData<List<MovieItem>>()

    fun getTopRated() {
        viewModelScope.launch {
            showProgress()
            topRatedLiveData.value = topRatedUseCase.execute(GetTopRatedUseCase.Params(1))
            hideProgress()
        }
    }

    fun getNowPlaying() {
        viewModelScope.launch {
            showProgress()
            nowPlayingLiveData.value = getNowPlayingUseCase.execute(GetNowPlayingUseCase.Params(1))
            hideProgress()
        }
    }

    suspend fun readAllFav() = readAllFromFavUseCase.execute("")
}