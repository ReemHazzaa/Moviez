package com.example.moviez.utils.genericadapter.listener

import android.view.View
import com.nwc.employeecare.presentation.utils.genericadapter.Listable

interface OnItemClickCallback {
    fun onItemClicked(view: View, listableItem: Listable, position: Int)
}