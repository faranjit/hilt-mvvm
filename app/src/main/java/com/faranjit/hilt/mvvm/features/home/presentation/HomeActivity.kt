package com.faranjit.hilt.mvvm.features.home.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.faranjit.hilt.mvvm.base.BaseActivity
import com.faranjit.hilt.mvvm.base.viewBinding
import com.faranjit.hilt.mvvm.databinding.ActivityHomeBinding
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.all.AllServicesAdapter
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.PopularAdapter
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.post.PostAdapter
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.post.PostClickListener
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.post.PostItem
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity :
    BaseActivity<HomeViewModel, ActivityHomeBinding>(), PostClickListener {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    private val popularAdapter = PopularAdapter()
    private val allServicesAdapter = AllServicesAdapter()
    private val postsAdapter = PostAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            search.bringToFront()

            recyclerAllServices.adapter = allServicesAdapter
            recyclerPopular.adapter = popularAdapter
            recyclerPost.adapter = postsAdapter

            txtEmpty.setOnClickListener {
                viewModel?.getHomeFeedFlow(false)
            }
        }

        observe()
    }

    override fun provideViewModel() = viewModels<HomeViewModel> { viewModelFactory }.value

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun onPostClick(item: PostItem) {
        TODO("Not yet implemented")
    }

    private fun observe() {
        viewModel.allServicesLiveData.observe(this) {
            allServicesAdapter.submitList(it)
        }

        viewModel.popularItemsLiveData.observe(this) {
            popularAdapter.submitList(it)
        }

        viewModel.postItemsLiveData.observe(this) {
            postsAdapter.submitList(it)
        }
    }
}