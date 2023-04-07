package com.example.moviez.app.ui.home

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviez.R
import com.example.moviez.app.base.BaseFragment
import com.example.moviez.app.extensions.updateStatusBarColor
import com.example.moviez.app.ui.SharedViewModel
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.utils.genericadapter.adapter.GeneralListAdapter
import com.example.moviez.app.utils.genericadapter.listener.OnItemClickCallback
import com.example.moviez.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<SharedViewModel, FragmentHomeBinding>() {
    override val layoutResId: Int = R.layout.fragment_home
    override val mViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getTopRatedAndNowPlaying()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().updateStatusBarColor(R.color.primaryColor, false)

        viewDataBinding.apply {
            setVariable(BR.viewModel, mViewModel)

            searchView.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_searchFragment)
            }

            swipeRefresh.setOnRefreshListener {
                swipeRefresh.isRefreshing = true
                getTopRatedAndNowPlaying()
                swipeRefresh.isRefreshing = false
            }

            rvTopRated.adapter =
                GeneralListAdapter(context = requireContext(), onItemClickCallback = object :
                    OnItemClickCallback {
                    override fun onItemClicked(view: View, listableItem: Listable, position: Int) {
                        findNavController().navigate(R.id.action_navigation_home_to_movieDetailsFragment)
                    }
                })

            rvNowPlaying.adapter =
                GeneralListAdapter(context = requireContext(), onItemClickCallback = object :
                    OnItemClickCallback {
                    override fun onItemClicked(view: View, listableItem: Listable, position: Int) {

                    }
                })
        }
    }

    private fun getTopRatedAndNowPlaying() {
        mViewModel.getTopRated()
        mViewModel.getNowPlaying()
    }
}