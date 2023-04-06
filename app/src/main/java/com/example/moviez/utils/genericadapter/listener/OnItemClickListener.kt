package com.example.moviez.utils.genericadapter.listener

import android.view.View
import com.example.moviez.utils.genericadapter.Listable

open class OnItemClickListener(
    private var position: Int,
    val onItemClickCallback: OnItemClickCallback
) : View.OnClickListener {
    private var listableItem: Listable? = null
    override fun onClick(view: View) {
        onItemClickCallback.onItemClicked(view, listableItem!!, position)
    }

    fun setPosition(position: Int) {
        this.position = position
    }

    fun setListableItem(listableItem: Listable?) {
        this.listableItem = listableItem
    }

}