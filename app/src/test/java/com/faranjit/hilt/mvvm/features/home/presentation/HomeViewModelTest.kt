package com.faranjit.hilt.mvvm.features.home.presentation

import com.faranjit.hilt.mvvm.BaseUnitTest
import com.faranjit.hilt.mvvm.features.home.domain.FakeHomeRepository
import com.faranjit.hilt.mvvm.features.home.domain.interactor.GetHomeFeed
import com.faranjit.hilt.mvvm.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@ExperimentalCoroutinesApi
class HomeViewModelTest : BaseUnitTest() {

    private val getHomeFeed = GetHomeFeed(FakeHomeRepository())

    private lateinit var viewModel: HomeViewModel

    @Test
    fun shouldGetHomeFeedReturnsSuccess() {
        testScope.launch {
            // Given

            // When
            viewModel = HomeViewModel(getHomeFeed)
            val popularItems = viewModel.popularItemsLiveData.getOrAwaitValue()

            // Then
            assertNotNull(popularItems)
            assertEquals(3, popularItems.size)
        }
    }
}