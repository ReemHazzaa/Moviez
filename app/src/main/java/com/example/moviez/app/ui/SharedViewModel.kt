package com.example.moviez.app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviez.domain.usecase.topRated.GetTopRatedUseCase
import com.example.moviez.app.base.BaseViewModel
import com.example.moviez.app.entity.MovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val topRatedUseCase: GetTopRatedUseCase) :
    BaseViewModel() {

    val topRatedLiveData = MutableLiveData<List<MovieItem>>()

    fun getTopRated() {
        viewModelScope.launch {
            showProgress()
            topRatedLiveData.value = topRatedUseCase.execute(GetTopRatedUseCase.Params(1))
            hideProgress()
        }
    }
}