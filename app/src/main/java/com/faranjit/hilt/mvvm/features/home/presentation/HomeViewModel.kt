package com.faranjit.hilt.mvvm.features.home.presentation

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.faranjit.hilt.mvvm.base.BaseResult
import com.faranjit.hilt.mvvm.base.BaseViewModel
import com.faranjit.hilt.mvvm.features.home.domain.interactor.GetHomeFeed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeFeed: GetHomeFeed
) : BaseViewModel() {

    val textObservable = ObservableField<String>()

    init {
        viewModelScope.launch {
            getHomeFeed.execute().collect {
                when (it) {
                    is BaseResult.Loading -> showLoading(it.showing)
                    is BaseResult.Success -> textObservable.set(it.toString())
                    is BaseResult.Error -> TODO()
                }
            }
        }
    }
}