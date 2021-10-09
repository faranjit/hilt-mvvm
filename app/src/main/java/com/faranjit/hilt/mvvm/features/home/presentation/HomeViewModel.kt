package com.faranjit.hilt.mvvm.features.home.presentation

import androidx.databinding.ObservableField
import com.faranjit.hilt.mvvm.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    val textObservable = ObservableField<String>()

    init {
        textObservable.set("Hello MVVM!")
    }
}