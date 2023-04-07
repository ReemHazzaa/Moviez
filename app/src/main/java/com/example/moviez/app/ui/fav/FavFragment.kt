package com.example.moviez.app.ui.fav

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.moviez.R
import com.example.moviez.app.adapter.FavAdapter
import com.example.moviez.app.base.BaseFragment
import com.example.moviez.app.extensions.updateStatusBarColor
import com.example.moviez.databinding.FragmentFavBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavFragment : BaseFragment<FavViewModel, FragmentFavBinding>() {

    override val layoutResId: Int = R.layout.fragment_fav
    override val mViewModel: FavViewModel by viewModels()

    private val favAdapter = FavAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().updateStatusBarColor(R.color.grey_E3E2E5, false)
        viewDataBinding.apply {
            setVariable(BR.viewModel, mViewModel)
        }

        lifecycleScope.launch {
            mViewModel.readAllFav().observe(viewLifecycleOwner) { fav ->
                favAdapter.setData(fav)
                viewDataBinding.rvCourses.adapter = favAdapter
            }
        }
    }
}