package com.example.moviez.utils.bindingadapters

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.moviez.R

object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImageWithGlide")
    fun ImageView.loadImageWithGlide(url: String?) {
        try {
            Glide
                .with(this.rootView)
                .load(url)
                .centerCrop()
                .error(R.drawable.baseline_error_outline_24)
                .placeholder(R.drawable.baseline_downloading_24)
                .into(this)

        } catch (e: java.lang.Exception) {
            Log.e("Glide", e.toString())
        }
    }

}