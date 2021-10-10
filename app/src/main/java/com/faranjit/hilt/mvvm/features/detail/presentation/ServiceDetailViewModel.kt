package com.faranjit.hilt.mvvm.features.detail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.BaseViewModel
import com.faranjit.hilt.mvvm.base.succeeded
import com.faranjit.hilt.mvvm.features.detail.domain.interactor.GetServiceDetail
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
@HiltViewModel
class ServiceDetailViewModel @Inject constructor(
    private val getServiceDetail: GetServiceDetail
) : BaseViewModel() {

    private val detailResponse = MutableLiveData<ServiceDetailModel>()

    fun getServiceDetail(serviceId: Int) {
        viewModelScope.launch {
            getServiceDetail.execute(
                GetServiceDetail.Params(serviceId)
            ).collect {
                when (it) {
                    is BaseResult.Loading -> showLoading(it.showing)
                    is BaseResult.Error -> handleError(it.exception.message)
                    is BaseResult.Success -> if (it.succeeded) handleResponse(it.data)
                }
            }
        }
    }

    private fun handleResponse(detailModel: ServiceDetailModel) {
        detailResponse.value = detailModel
    }

    private fun handleError(message: String?) {

    }
}