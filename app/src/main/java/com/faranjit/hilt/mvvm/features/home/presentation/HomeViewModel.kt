package com.faranjit.hilt.mvvm.features.home.presentation

import androidx.lifecycle.*
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.BaseViewModel
import com.faranjit.hilt.mvvm.base.succeeded
import com.faranjit.hilt.mvvm.features.home.domain.interactor.GetHomeFeed
import com.faranjit.hilt.mvvm.features.home.domain.model.FeedModel
import com.faranjit.hilt.mvvm.features.home.domain.model.ServiceModel
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
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeFeed: GetHomeFeed
) : BaseViewModel() {

    companion object {
        private const val RANDOM_SEED = 20
        private const val RANDOM_THRESHOLD = 7
    }

    private val allServices = MutableLiveData<List<AllServiceItem>>()
    val allServicesLiveData: LiveData<List<AllServiceItem>>
        get() = allServices

    private val popularItems = MutableLiveData<List<PopularItem>>()
    val popularItemsLiveData: LiveData<List<PopularItem>>
        get() = popularItems

    private val postItems = MutableLiveData<List<PostItem>>()
    val postItemsLiveData: LiveData<List<PostItem>>
        get() = postItems

    private val openDetail = MutableLiveData<ServiceModel>()
    val openDetailLiveData: LiveData<ServiceModel>
        get() = openDetail

    private val feedResponse = MutableLiveData<FeedModel?>()
    val resultVisibilityObservable = feedResponse.switchMap {
        liveData(viewModelScope.coroutineContext) {
            it?.let {
                parseFeedResponse(it)
                emit(true)
            } ?: run {
                emit(false)
            }
        }
    }

    init {
        getHomeFeedFlow(Random.nextInt(0..RANDOM_SEED) < RANDOM_THRESHOLD)
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
                feedResponse.value = null
            } else {
                getHomeFeed.execute().collect {
                    when (it) {
                        is BaseResult.Loading -> showLoading(it.showing)
                        is BaseResult.Success -> if (it.succeeded) {
                            feedResponse.value = it.data
                        } else {
                            feedResponse.value = null
                        }
                        is BaseResult.Error -> feedResponse.value = null
                    }
                }
            }
        }
    }

    fun findAndOpenServiceDetail(item: AllServiceItem) {
        feedResponse.value?.allServices?.find { it.id == item.id }?.let {
            openDetail.value = it
        }
    }

    fun findAndOpenServiceDetail(item: PopularItem) {
        feedResponse.value?.popularServices?.find { it.id == item.id }?.let {
            openDetail.value = it
        }
    }

    private fun parseFeedResponse(feed: FeedModel) {
        allServices.value = feed.allServices.mapToAllServiceItems()
        popularItems.value = feed.popularServices.mapToPopularItems()
        postItems.value = feed.posts.mapToPostItems()
    }
}