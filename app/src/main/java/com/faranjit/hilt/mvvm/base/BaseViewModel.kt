package com.faranjit.hilt.mvvm.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
abstract class BaseViewModel : ViewModel() {

    private val loading = MutableLiveData(false)
    val loadingLiveData: LiveData<Boolean>
        get() = loading

    fun showLoading(show: Boolean) {
        loading.postValue(show)
    }
}