package com.faranjit.hilt.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.ViewDataBinding
import com.faranjit.hilt.mvvm.R

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
abstract class BaseActivity<VM : BaseViewModel, VB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewModel: VM

    private val progressDialog: AppCompatDialog? by lazy {
        AppCompatDialog(this, R.style.ProgressDialog).apply {
            setContentView(R.layout.dialog_loading)
            setCancelable(false)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = provideViewModel()
        bindViewModel()

        viewModel.loadingLiveData.observe(this, {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        })
    }

    abstract fun provideViewModel(): VM

    abstract fun bindViewModel()

    protected fun showLoading() {
        progressDialog?.show()
    }

    protected fun hideLoading() {
        progressDialog?.dismiss()
    }
}