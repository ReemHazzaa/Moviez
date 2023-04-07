package com.example.moviez.app.utils.genericadapter.listener

import android.view.View
import com.example.moviez.app.utils.genericadapter.Listable

interface OnItemClickCallback {
    fun onItemClicked(view: View, listableItem: Listable, position: Int)
}