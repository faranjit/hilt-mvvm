package com.faranjit.hilt.mvvm.features.home.data.source

import com.faranjit.hilt.mvvm.BaseUnitTest
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.data.response.Service
import com.faranjit.hilt.mvvm.features.home.domain.HomeApi
import com.faranjit.hilt.mvvm.features.home.domain.interactor.FeedResponseMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@ExperimentalCoroutinesApi
class HomeRemoteDataSourceTest : BaseUnitTest() {

    @Mock
    private lateinit var homeApi: HomeApi

    private lateinit var remoteDataSource: HomeRemoteDataSource

    override fun setup() {
        super.setup()
        remoteDataSource = HomeRemoteDataSource(homeApi, FeedResponseMapper)
    }

    @Test
    fun shouldGetHomeFeedReturnsSuccess() = runBlockingTest {
        // Given
        val response = FeedResponse(
            allServices = emptyList(),
            posts = emptyList(),
            popularServices = listOf(
                Service(1, 1, "Service 1"),
                Service(2, 2, "Service 1"),
                Service(3, 3, "Service 1")
            )
        )

        // When
        `when`(homeApi.getHomeFeed()).thenReturn(response)
        val feedResponse = remoteDataSource.getHomeFeed()

        // Then
        verify(homeApi).getHomeFeed()
        assert(feedResponse is BaseResult.Success)
        assert((feedResponse as BaseResult.Success).data.popularServices.size == 3)
    }

    @Test
    fun shouldGetHomeFeedReturnsError() = runBlockingTest {
        // Given
        val ex = Exception("this is an error")

        // When
        doThrow(ex).`when`(homeApi).getHomeFeed()
//        `when`(homeApi.getHomeFeed()).thenThrow(ex)
        val feedResponse = remoteDataSource.getHomeFeed()

        // Then
        verify(homeApi).getHomeFeed()
        assert(feedResponse is BaseResult.Error)
        assertEquals(ex, (feedResponse as BaseResult.Error).exception)
    }
}