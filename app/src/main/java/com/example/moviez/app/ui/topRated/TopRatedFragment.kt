package com.example.moviez.app.ui.topRated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviez.R
import com.example.moviez.app.base.BaseFragment
import com.example.moviez.app.entity.MovieItem
import com.example.moviez.app.extensions.updateStatusBarColor
import com.example.moviez.app.ui.SharedViewModel
import com.example.moviez.app.ui.home.HomeFragmentDirections
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.utils.genericadapter.adapter.GeneralListAdapter
import com.example.moviez.app.utils.genericadapter.listener.OnItemClickCallback
import com.example.moviez.databinding.FragmentHomeBinding
import com.example.moviez.databinding.FragmentTopRatedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopRatedFragment : BaseFragment<SharedViewModel, FragmentTopRatedBinding>() {
    override val layoutResId: Int = R.layout.fragment_top_rated
    override val mViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getTopRated()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().updateStatusBarColor(R.color.grey_E3E2E5)
        viewDataBinding.apply {
            setVariable(BR.viewModel, mViewModel)

            swipeRefresh.setOnRefreshListener {
                swipeRefresh.isRefreshing = true
                getTopRated()
                swipeRefresh.isRefreshing = false
            }

            rvMovies.adapter =
                GeneralListAdapter(context = requireContext(), onItemClickCallback = object :
                    OnItemClickCallback {
                    override fun onItemClicked(view: View, listableItem: Listable, position: Int) {
                        val itemId = (listableItem as MovieItem).id
                        val action = TopRatedFragmentDirections.actionNavigationTopRatedToMovieDetailsFragment(itemId)
                        findNavController().navigate(action)
                    }
                })
        }
    }

    private fun getTopRated() {
        mViewModel.getTopRated()
    }

}