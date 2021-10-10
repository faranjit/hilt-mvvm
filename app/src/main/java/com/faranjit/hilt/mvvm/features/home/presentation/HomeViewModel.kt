package com.faranjit.hilt.mvvm.features.home.presentation

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.BaseViewModel
import com.faranjit.hilt.mvvm.base.succeeded
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.domain.interactor.GetHomeFeed
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.all.AllServiceItem
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.all.mapToAllServiceItems
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.PopularItem
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular.mapToPopularItems
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.post.PostItem
import com.faranjit.hilt.mvvm.features.home.presentation.adapter.post.mapToPostItems
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

    private val postItems = MutableLiveData<List<PostItem>>()
    val postItemsLiveData: LiveData<List<PostItem>>
        get() = postItems

    val resultVisibilityObservable = ObservableBoolean(true)

    init {
        getHomeFeedFlow(true)
    }

    /**
     * Get home data from remote api as flow.
     * It shows dummy error if showDummyError parameter set true.
     *
     * @param showDummyError shows an error message or shows the actual results
     */
    fun getHomeFeedFlow(showDummyError: Boolean = false) {
        viewModelScope.launch {
            if (showDummyError) {
                resultVisibilityObservable.set(false)
            } else {
                getHomeFeed.execute().collect {
                    when (it) {
                        is BaseResult.Loading -> showLoading(it.showing)
                        is BaseResult.Success -> if (it.succeeded) {
                            resultVisibilityObservable.set(true)
                            parseFeedResponse(it.data)
                        } else {
                            resultVisibilityObservable.set(false)
                        }
                        is BaseResult.Error -> resultVisibilityObservable.set(false)
                    }
                }
            }
        }
    }

    private fun parseFeedResponse(feed: FeedResponse) {
        allServices.value = feed.allServices.mapToAllServiceItems()
        popularItems.value = feed.popularServices.mapToPopularItems()
        postItems.value = feed.posts.mapToPostItems()
    }
}