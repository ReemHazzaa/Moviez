package com.example.moviez.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.data.remote.networkLayer.NetworkFailure
import com.example.moviez.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialog : BottomSheetDialogFragment() {

    protected abstract val layoutResId: Int
    protected open val dataBindingEnabled: Boolean = false
    protected var viewDataBinding: ViewDataBinding? = null
    private var loadingProgressBar: LoadingProgressDialog? = null


    @BottomSheetBehavior.State
    var forcedBehaviour: Int? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        forcedBehaviour?.let { forcedBehaviour ->
            dialog.behavior.state = forcedBehaviour
            dialog.behavior.peekHeight = BottomSheetBehavior.PEEK_HEIGHT_AUTO
        }

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view: View?
        if (dataBindingEnabled) {
            viewDataBinding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
            view = viewDataBinding?.root
        } else {
            view = inflater.inflate(layoutResId, container, false)
        }
        return view
    }

    @Suppress("UNCHECKED_CAST")
    protected inline fun <T : ViewDataBinding> bind(binding: T.() -> Unit) {
        binding(viewDataBinding as T)
        viewDataBinding?.executePendingBindings()
    }

    protected fun handleLoading(loadingState: Boolean) {
        if (loadingState) {
            showLoading()
        } else {
            hideLoading()
        }
    }

    protected fun showLoading() {
        if (loadingProgressBar == null) {
            loadingProgressBar = LoadingProgressDialog(context)
        }

        if (loadingProgressBar?.isShowing == false) {
            loadingProgressBar?.show()
        }
    }

    protected fun hideLoading() {
        loadingProgressBar?.hide()
    }

    protected fun showFailure(failure: NetworkFailure) {
        when (failure) {
            is NetworkFailure.NetworkConnection -> showNetworkConnection()
            is NetworkFailure.NetworkError -> showNetworkError()
            is NetworkFailure.ServerError -> showServerError(failure.message)
            is NetworkFailure.UnknownError -> showUnknownError()
        }
    }

    protected fun showNetworkConnection() {
        showToast(getString(R.string.no_connection))
    }

    protected fun showNetworkError() {
        showToast(getString(R.string.no_connection))
    }

    protected fun showServerError(message: String) {
        showToast(message)
    }

    protected fun showUnknownError() {
        showToast(getString(R.string.try_again))
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        viewDataBinding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        loadingProgressBar?.cancel()
        loadingProgressBar = null
        super.onDestroy()
    }

}