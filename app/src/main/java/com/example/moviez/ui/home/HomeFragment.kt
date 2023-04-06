package com.example.moviez.ui.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.moviez.R
import com.example.moviez.base.BaseFragment
import com.example.moviez.databinding.FragmentHomeBinding
import com.example.moviez.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<SharedViewModel, FragmentHomeBinding>() {
    override val layoutResId: Int = R.layout.fragment_home
    override val mViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.getTopRated()
    }
}