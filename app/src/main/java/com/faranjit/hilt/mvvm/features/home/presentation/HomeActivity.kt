package com.faranjit.hilt.mvvm.features.home.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.faranjit.hilt.mvvm.base.BaseActivity
import com.faranjit.hilt.mvvm.base.viewBinding
import com.faranjit.hilt.mvvm.databinding.ActivityHomeBinding
import com.faranjit.hilt.mvvm.features.detail.presentation.ServiceDetailActivity
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.all.AllServiceItem
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.all.AllServicesAdapter
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.all.ServiceItemClickListener
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.PopularAdapter
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.PopularItem
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.PopularItemClickListener
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.post.PostAdapter
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.post.PostClickListener
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.post.PostItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity :
    BaseActivity<HomeViewModel, ActivityHomeBinding>(),
    PostClickListener,
    ServiceItemClickListener,
    PopularItemClickListener {

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    private val allServicesAdapter = AllServicesAdapter(this)
    private val popularAdapter = PopularAdapter(this)
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

    override fun provideViewModel() = viewModels<HomeViewModel>().value

    override fun bindViewModel() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    override fun onServiceItemClick(item: AllServiceItem) {
        viewModel.findAndOpenServiceDetail(item)
    }

    override fun onPopularItemClick(item: PopularItem) {
        viewModel.findAndOpenServiceDetail(item)
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

        viewModel.openDetailLiveData.observe(this) {
            startActivity(ServiceDetailActivity.newIntent(this, it))
        }
    }
}