package com.faranjit.hilt.mvvm.features.home.presentation

import androidx.activity.viewModels
import com.faranjit.hilt.mvvm.base.BaseActivity
import com.faranjit.hilt.mvvm.base.viewBinding
import com.faranjit.hilt.mvvm.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val viewModel by viewModels<HomeViewModel>()

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }
}