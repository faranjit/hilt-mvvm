package com.faranjit.hilt.mvvm.features.detail.domain.interactor

import com.faranjit.hilt.mvvm.features.detail.data.response.ServiceDetailResponse
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
class ServiceDetailResponseMapperTest {

    @Test
    fun shouldMapperMapReturnsSuccess() {
        // Given
        val response = ServiceDetailResponse(
            id = 1,
            serviceId = 61,
            name = "Detail Service"
        )

        // When
        val model = ServiceDetailResponseMapper.map(response)

        // Then
        assertEquals(response.id, model.id)
        assertEquals(response.serviceId, model.serviceId)
        assertEquals(response.name, model.name)
    }
}