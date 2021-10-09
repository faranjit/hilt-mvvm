package com.faranjit.hilt.mvvm.features.home.data

import com.faranjit.hilt.mvvm.BaseUnitTest
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.features.home.data.response.FeedResponse
import com.faranjit.hilt.mvvm.features.home.data.response.Service
import com.faranjit.hilt.mvvm.features.home.data.source.HomeRemoteDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@ExperimentalCoroutinesApi
class HomeDataRepositoryTest : BaseUnitTest() {

    @Mock
    private lateinit var remoteDataSource: HomeRemoteDataSource

    private val ioDispatcher = dispatcher

    private lateinit var repository: HomeDataRepository

    override fun setup() {
        super.setup()
        repository = HomeDataRepository(remoteDataSource, ioDispatcher)
    }

    @Test
    fun shouldGetHomeFeedReturnsSuccess() = runBlockingTest {
        // Given
        val response = BaseResult.Success(
            FeedResponse(
                allServices = emptyList(),
                posts = emptyList(),
                popularServices = listOf(
                    Service(1, 1, "Service 1"),
                    Service(2, 2, "Service 1"),
                    Service(3, 3, "Service 1")
                )
            )
        )

        // When
        `when`(remoteDataSource.getHomeFeed()).thenReturn(response)
        val feedResponse = repository.getHomeFeed()

        // Then
        verify(remoteDataSource).getHomeFeed()
        assertEquals(response, feedResponse)
    }
}