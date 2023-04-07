package com.example.moviez.app.base

import androidx.lifecycle.ViewModel
import com.example.moviez.data.remote.networkLayer.NetworkFailure
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel :
    ViewModel() {


    var progressLiveData: ObserveOnceLiveData<Boolean>? = ObserveOnceLiveData()
        private set

    var failureLiveData: ObserveOnceLiveData<NetworkFailure>? = ObserveOnceLiveData()
        private set

    var toastRes: ObserveOnceLiveData<Int> = ObserveOnceLiveData()
        private set

    fun showProgress() {
        progressLiveData?.value = true
    }

    fun hideProgress() {
        progressLiveData?.value = false
    }

    fun showFailure(failure: NetworkFailure) {
        failureLiveData?.value = failure
    }

    fun showResourceToast(res: Int) {
        toastRes.value = res
    }

    fun getExceptionHandler(): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, throwable ->
            hideProgress()
            if (throwable is NetworkFailure)
                showFailure(throwable)
            else showFailure(NetworkFailure.NetworkError)
        }
    }

    class NoneViewModel : BaseViewModel()
}