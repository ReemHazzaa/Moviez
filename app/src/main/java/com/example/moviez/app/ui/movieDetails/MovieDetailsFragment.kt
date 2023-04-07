package com.example.moviez.app.ui.movieDetails

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.moviez.R
import com.example.moviez.app.base.BaseFragment
import com.example.moviez.app.extensions.updateStatusBarColor
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.utils.genericadapter.adapter.GeneralListAdapter
import com.example.moviez.app.utils.genericadapter.listener.OnItemClickCallback
import com.example.moviez.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<MovieDetailsViewModel, FragmentMovieDetailsBinding>() {

    override val layoutResId: Int = R.layout.fragment_movie_details
    override val mViewModel: MovieDetailsViewModel by viewModels()

    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.getMovieDetails(args.movieID)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().updateStatusBarColor(R.color.grey_E3E2E5, false)
        viewDataBinding.apply {
            setVariable(BR.viewModel, mViewModel)

            rvGenres.adapter =
                GeneralListAdapter(context = requireContext(), onItemClickCallback = object :
                    OnItemClickCallback {
                    override fun onItemClicked(view: View, listableItem: Listable, position: Int) {

                    }
                })

            swipeRefresh.setOnRefreshListener {
                swipeRefresh.isRefreshing = true
                mViewModel.getMovieDetails(args.movieID)
                swipeRefresh.isRefreshing = false
            }
        }
    }
}