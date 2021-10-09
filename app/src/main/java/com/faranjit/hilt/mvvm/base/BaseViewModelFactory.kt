package com.faranjit.hilt.mvvm.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Bulent Turkmen on 24.09.2021.
 */
abstract class BaseViewModelFactory<VM : BaseViewModel> : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = provideViewModel()

        if (modelClass.isAssignableFrom(viewModel.javaClass)) {
            return viewModel as T
        }

        throw IllegalArgumentException("Unknown ViewModel: ${modelClass.name}")
    }

    abstract fun provideViewModel(): VM
}