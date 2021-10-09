package com.faranjit.hilt.mvvm.features.home.presentation

import androidx.activity.viewModels
import com.faranjit.hilt.mvvm.base.BaseActivity
import com.faranjit.hilt.mvvm.base.viewBinding
import com.faranjit.hilt.mvvm.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    override fun provideViewModel() = viewModels<HomeViewModel> { viewModelFactory }.value

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }
}