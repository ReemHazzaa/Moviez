package com.example.moviez.app.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviez.app.base.BaseViewModel
import com.example.moviez.app.base.ObserveOnceLiveData
import com.example.moviez.app.entity.SearchItem
import com.example.moviez.domain.usecase.searchByName.SearchByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchByNameUseCase: SearchByNameUseCase
) : BaseViewModel() {
    val searchResultLiveData = ObserveOnceLiveData<List<SearchItem>>()
    val searchString: ObserveOnceLiveData<String> = ObserveOnceLiveData()
    fun searchByName(
        page: Int,
        includeAdult: Boolean,
        movieName: String
    ) {
        viewModelScope.launch {
            showProgress()
            searchResultLiveData.value = searchByNameUseCase.execute(
                SearchByNameUseCase.Params(
                    page,
                    includeAdult,
                    movieName
                )
            )
            hideProgress()
        }
    }
}