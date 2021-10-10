package com.faranjit.hilt.mvvm.features.home.presentation

import com.faranjit.hilt.mvvm.BaseUnitTest
import com.faranjit.hilt.mvvm.features.home.domain.FakeHomeRepository
import com.faranjit.hilt.mvvm.features.home.domain.interactor.GetHomeFeed
import com.faranjit.hilt.mvvm.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@ExperimentalCoroutinesApi
class HomeViewModelTest : BaseUnitTest() {

    private val getHomeFeed = GetHomeFeed(FakeHomeRepository())

    private lateinit var viewModel: HomeViewModel

    override fun setup() {
        viewModel = HomeViewModel(getHomeFeed)
    }

    @Test
    fun shouldGetHomeFeedReturnsSuccess() {
        testScope.launch {
            // Given

            // When
            val popularItems = viewModel.popularItemsLiveData.getOrAwaitValue()
            val allItems = viewModel.allServicesLiveData.getOrAwaitValue()
            val posts = viewModel.postItemsLiveData.getOrAwaitValue()

            // Then
            assertNotNull(popularItems)
            assertNotNull(allItems)
            assertNotNull(posts)
        }
    }

    @Test
    fun shouldDisplayEmptyMessage() {
        // Given

        // When
        viewModel.getHomeFeedFlow(true)

        // Then
        assertFalse(viewModel.resultVisibilityObservable.get())
    }

    @Test
    fun shouldDisplayResults() {
        // Given

        // When
        viewModel.getHomeFeedFlow(false)

        // Then
        assertTrue(viewModel.resultVisibilityObservable.get())
    }
}