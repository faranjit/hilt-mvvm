package com.faranjit.hilt.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViewModel()
    }

    abstract fun bindViewModel()
}