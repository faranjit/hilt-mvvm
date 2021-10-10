package com.faranjit.hilt.mvvm.features.home.domain.interactor

import com.faranjit.hilt.mvvm.BaseUnitTest
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.home.domain.HomeRepository
import com.faranjit.hilt.mvvm.features.home.domain.model.FeedModel
import com.faranjit.hilt.mvvm.features.home.domain.model.ServiceModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@ExperimentalCoroutinesApi
class GetHomeFeedTest : BaseUnitTest() {

    @Mock
    private lateinit var homeRepository: HomeRepository

    @InjectMocks
    private lateinit var getHomeFeed: GetHomeFeed

    @Test
    fun shouldGetHomeFeedReturnsSuccess() = runBlockingTest {
        // Given
        val response = BaseResult.Success(
            FeedModel(
                allServices = emptyList(),
                posts = emptyList(),
                popularServices = listOf(
                    ServiceModel(1, 1, "Service 1"),
                    ServiceModel(2, 2, "Service 1"),
                    ServiceModel(3, 3, "Service 1")
                )
            )
        )

        var feedResponse: FeedModel? = null
        var loadingCount = 0

        // When
        `when`(homeRepository.getHomeFeed()).thenReturn(response)
        getHomeFeed.execute().collect {
            when (it) {
                is BaseResult.Loading -> loadingCount++
                is BaseResult.Success -> feedResponse = it.data
                is BaseResult.Error -> TODO()
            }
        }

        // Then
        assertNotNull(feedResponse)
        assertEquals(2, loadingCount)
    }
}