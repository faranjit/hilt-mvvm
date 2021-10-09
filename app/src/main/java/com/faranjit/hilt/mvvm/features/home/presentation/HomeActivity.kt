package com.faranjit.hilt.mvvm.features.home.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.faranjit.hilt.mvvm.base.BaseActivity
import com.faranjit.hilt.mvvm.base.viewBinding
import com.faranjit.hilt.mvvm.databinding.ActivityHomeBinding
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.PopularAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    private val popularAdapter = PopularAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            recyclerPopular.adapter = popularAdapter
        }

        observe()
    }

    override fun provideViewModel() = viewModels<HomeViewModel> { viewModelFactory }.value

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    private fun observe() {
        viewModel.popularItemsLiveData.observe(this) {
            popularAdapter.submitList(it)
        }
    }
}