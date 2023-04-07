package com.example.moviez.app.ui.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviez.R
import com.example.moviez.app.base.BaseFragment
import com.example.moviez.app.extensions.updateStatusBarColor
import com.example.moviez.app.utils.genericadapter.Listable
import com.example.moviez.app.utils.genericadapter.adapter.GeneralListAdapter
import com.example.moviez.app.utils.genericadapter.listener.OnItemClickCallback
import com.example.moviez.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {
    override val layoutResId: Int = R.layout.fragment_search
    override val mViewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().updateStatusBarColor(R.color.grey_E3E2E5, false)

        viewDataBinding.apply {
            setVariable(BR.viewModel, mViewModel)

            searchView.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_searchFragment)
            }

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    newText?.let {
                        mViewModel.searchString.value = it
                        mViewModel.searchByName(1, false, it)
                    }
                    return false
                }

            })

            swipeRefresh.setOnRefreshListener {
                swipeRefresh.isRefreshing = true
                mViewModel.searchString.value?.let { mViewModel.searchByName(1, false, it) }
                swipeRefresh.isRefreshing = false
            }

            rvResult.adapter =
                GeneralListAdapter(context = requireContext(), onItemClickCallback = object :
                    OnItemClickCallback {
                    override fun onItemClicked(view: View, listableItem: Listable, position: Int) {

                    }
                })
        }
    }

}