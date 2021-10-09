package com.faranjit.hilt.mvvm.features.home.presentation

import com.faranjit.hilt.mvvm.base.BaseViewModelFactory
import com.faranjit.hilt.mvvm.features.home.domain.interactor.GetHomeFeed
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class HomeViewModelFactory @Inject constructor(
    private val getHomeFeed: GetHomeFeed
) : BaseViewModelFactory<HomeViewModel>() {

    override fun provideViewModel() = HomeViewModel(getHomeFeed)
}