package com.faranjit.hilt.mvvm.features.detail.data.source

import com.faranjit.hilt.mvvm.BaseUnitTest
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.succeeded
import com.faranjit.hilt.mvvm.features.detail.data.response.ServiceDetailResponse
import com.faranjit.hilt.mvvm.features.detail.domain.ServiceDetailApi
import com.faranjit.hilt.mvvm.features.detail.domain.interactor.ServiceDetailResponseMapper
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
@ExperimentalCoroutinesApi
class ServiceDetailRemoteDataSourceTest : BaseUnitTest() {

    @Mock
    private lateinit var detailApi: ServiceDetailApi

    private lateinit var remoteDataSource: ServiceDetailRemoteDataSource

    override fun setup() {
        super.setup()
        remoteDataSource = ServiceDetailRemoteDataSource(detailApi, ServiceDetailResponseMapper)
    }

    @Test
    fun shouldGetServiceDetailReturnsSuccess() = runBlockingTest {
        // Given
        val serviceId = 208
        val response = ServiceDetailResponse(
            id = 1,
            serviceId = serviceId,
            name = "Detail Service"
        )

        // When
        `when`(detailApi.getServiceDetail(serviceId)).thenReturn(response)
        val detailResponse = remoteDataSource.getServiceDetail(serviceId)

        // Then
        verify(detailApi).getServiceDetail(serviceId)
        assert(detailResponse is BaseResult.Success<ServiceDetailModel>)
        assertTrue(detailResponse.succeeded)
        assertTrue((detailResponse as BaseResult.Success).data.id == 1)
        assertTrue(detailResponse.data.serviceId == serviceId)
    }
}