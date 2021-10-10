package com.faranjit.hilt.mvvm.features.detail.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.faranjit.hilt.mvvm.base.BaseActivity
import com.faranjit.hilt.mvvm.base.viewBinding
import com.faranjit.hilt.mvvm.databinding.ActivityServiceDetailBinding
import com.faranjit.hilt.mvvm.features.home.domain.model.ServiceModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
@AndroidEntryPoint
class ServiceDetailActivity : BaseActivity<ServiceDetailViewModel, ActivityServiceDetailBinding>() {

    companion object {
        private const val KEY_SERVICE = "service"

        fun newIntent(context: Context, serviceModel: ServiceModel) =
            Intent(context, ServiceDetailActivity::class.java).apply {
                val bundle = Bundle()
                bundle.putParcelable(KEY_SERVICE, serviceModel)

                putExtras(bundle)
            }
    }

    private val binding by viewBinding(ActivityServiceDetailBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra(KEY_SERVICE)) {
            val serviceDetail = intent.getParcelableExtra<ServiceModel>(KEY_SERVICE)
            serviceDetail?.let {
                viewModel.getServiceDetail(it.serviceId)
                title = it.name
            }
        }
    }

    override fun provideViewModel() = viewModels<ServiceDetailViewModel>().value

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }
}