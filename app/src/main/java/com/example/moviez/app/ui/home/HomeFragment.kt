package com.example.moviez.app.ui.home

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.moviez.R
import com.example.moviez.app.adapter.FavHomeAdapter
import com.example.moviez.app.base.BaseFragment
import com.example.moviez.app.entity.MovieItem
import com.example.moviez.app.extensions.updateStatusBarColor
import com.example.moviez.app.ui.SharedViewModel
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.utils.genericadapter.adapter.GeneralListAdapter
import com.example.moviez.app.utils.genericadapter.listener.OnItemClickCallback
import com.example.moviez.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
                        val itemId = (listableItem as MovieItem).id
                        val action = HomeFragmentDirections.actionNavigationHomeToMovieDetailsFragment(itemId)
                        findNavController().navigate(action)
                    }
                })

            rvNowPlaying.adapter =
                GeneralListAdapter(context = requireContext(), onItemClickCallback = object :
                    OnItemClickCallback {
                    override fun onItemClicked(view: View, listableItem: Listable, position: Int) {
                        val itemId = (listableItem as MovieItem).id
                        val action = HomeFragmentDirections.actionNavigationHomeToMovieDetailsFragment(itemId)
                        findNavController().navigate(action)
                    }
                })

            lifecycleScope.launch {
                mViewModel.readAllFav().observe(viewLifecycleOwner) { fav ->
                    rvFav.adapter = FavHomeAdapter().apply { setData(fav) }
                }
            }
        }
    }

    private fun getTopRatedAndNowPlaying() {
        mViewModel.getTopRated()
        mViewModel.getNowPlaying()
    }
}