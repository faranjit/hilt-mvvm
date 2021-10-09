package com.faranjit.hilt.mvvm.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.BaseViewModel
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.domain.interactor.GetHomeFeed
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.all.AllServiceItem
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.all.mapToAllServiceItems
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.PopularItem
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.mapToPopularItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeFeed: GetHomeFeed
) : BaseViewModel() {

    private val allServices = MutableLiveData<List<AllServiceItem>>()
    val allServicesLiveData: LiveData<List<AllServiceItem>>
        get() = allServices

    private val popularItems = MutableLiveData<List<PopularItem>>()
    val popularItemsLiveData: LiveData<List<PopularItem>>
        get() = popularItems

    init {
        viewModelScope.launch {
            getHomeFeed.execute().collect {
                when (it) {
                    is BaseResult.Loading -> showLoading(it.showing)
                    is BaseResult.Success -> parseFeedResponse(it.data)
                    is BaseResult.Error -> TODO()
                }
            }
        }
    }

    private fun parseFeedResponse(feed: FeedResponse) {
        allServices.value = feed.allServices.mapToAllServiceItems()
        popularItems.value = feed.popularServices.mapToPopularItems()
    }
}