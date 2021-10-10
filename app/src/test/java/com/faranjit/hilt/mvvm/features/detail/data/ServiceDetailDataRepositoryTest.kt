package com.faranjit.hilt.mvvm.features.detail.data

import com.faranjit.hilt.mvvm.BaseUnitTest
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.succeeded
import com.faranjit.hilt.mvvm.features.detail.data.source.ServiceDetailRemoteDataSource
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
@ExperimentalCoroutinesApi
class ServiceDetailDataRepositoryTest : BaseUnitTest() {

    @Mock
    private lateinit var remoteDataSource: ServiceDetailRemoteDataSource

    private val ioDispatcher = dispatcher

    private lateinit var repository: ServiceDetailDataRepository

    override fun setup() {
        super.setup()
        repository = ServiceDetailDataRepository(remoteDataSource, ioDispatcher)
    }

    @Test
    fun shouldGetServiceDetailReturnsSuccess() = runBlockingTest {
        // Given
        val serviceId = 208
        val response = BaseResult.Success(
            ServiceDetailModel(
                id = 1,
                serviceId = serviceId,
                name = "Detail Service"
            )
        )

        // When
        `when`(remoteDataSource.getServiceDetail(serviceId)).thenReturn(response)
        val detailResponse = repository.getServiceDetail(serviceId)

        // Then
        verify(remoteDataSource).getServiceDetail(serviceId)
        assertTrue(detailResponse.succeeded)
        assertEquals(response, detailResponse)
    }

    @Test
    fun shouldGetServiceDetailReturnsError() = runBlockingTest {
        // Given
        val serviceId = -1
        val response =
            BaseResult.Error(Exception("The service that you requested could not found!"))

        // When
        `when`(remoteDataSource.getServiceDetail(serviceId)).thenReturn(response)
        val detailResponse = repository.getServiceDetail(serviceId)

        // Then
        verify(remoteDataSource).getServiceDetail(serviceId)
        assertFalse(detailResponse.succeeded)
        assertTrue(detailResponse is BaseResult.Error)
    }
}