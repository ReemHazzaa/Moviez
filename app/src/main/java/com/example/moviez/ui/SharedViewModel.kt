package com.example.moviez.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.movieList.MovieListResponse
import com.example.domain.usecase.topRated.GetTopRatedUseCase
import com.example.moviez.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val topRatedUseCase: GetTopRatedUseCase) :
    BaseViewModel() {

    val topRated = MutableLiveData<MovieListResponse>()

    fun getTopRated() {
        viewModelScope.launch {
            showProgress()
            topRated.value = topRatedUseCase.execute(GetTopRatedUseCase.Params(1))
            hideProgress()
        }
    }
}