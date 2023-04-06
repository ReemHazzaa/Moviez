package com.example.moviez.utils.genericadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviez.utils.genericadapter.Listable
import com.example.moviez.utils.genericadapter.listener.OnItemClickCallback

abstract class RecyclerArrayAdapter<M : Listable, VH : RecyclerView.ViewHolder>(
    context: Context,
    protected val onItemClickCallback: OnItemClickCallback?,
    dataDifferentiator : DiffUtil.ItemCallback<M>
) : PagingDataAdapter<M , VH>(dataDifferentiator) {
    val mInflater: LayoutInflater = LayoutInflater.from(context)
    fun empty(): Boolean {
        return itemCount == 0
    }

    suspend fun submitData(data: List<M>){
        submitData(PagingData.from(data))
    }

}
