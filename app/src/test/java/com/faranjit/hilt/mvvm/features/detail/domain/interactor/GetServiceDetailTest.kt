package com.faranjit.hilt.mvvm.features.detail.domain.interactor

import com.faranjit.hilt.mvvm.BaseUnitTest
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.succeeded
import com.faranjit.hilt.mvvm.features.detail.data.response.ServiceDetailResponse
import com.faranjit.hilt.mvvm.features.detail.domain.ServiceDetailRepository
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
@ExperimentalCoroutinesApi
class GetServiceDetailTest : BaseUnitTest() {

    @Mock
    private lateinit var repository: ServiceDetailRepository

    @InjectMocks
    private lateinit var getServiceDetail: GetServiceDetail

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

        var detailModel: ServiceDetailModel? = null
        var loadingCount = 0

        // When
        `when`(repository.getServiceDetail(serviceId)).thenReturn(response)
        getServiceDetail.execute(GetServiceDetail.Params(serviceId)).collect {
            when (it) {
                is BaseResult.Loading -> loadingCount++
                is BaseResult.Success -> detailModel = it.data
                is BaseResult.Error -> TODO()
            }
        }

        // Then
        verify(repository).getServiceDetail(serviceId)
        assertNotNull(detailModel)
        assertEquals(2, loadingCount)
    }

    @Test
    fun shouldGetServiceDetailReturnsError() = runBlockingTest {
        // Given
        val serviceId = -1

        var detailResponse: BaseResult<ServiceDetailResponse>? = null

        // When
        getServiceDetail.execute().collect {
            when (it) {
                is BaseResult.Error -> detailResponse = it
                else -> {
                }
            }
        }

        // Then
        assertNotNull(detailResponse)
        assert(detailResponse?.succeeded == false)
        assertTrue(detailResponse is BaseResult.Error)
    }
}