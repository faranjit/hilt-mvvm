package com.faranjit.hilt.mvvm.features.home.presentation.adapter.all

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.faranjit.hilt.mvvm.R
import com.faranjit.hilt.mvvm.base.list.BaseAdapter
import com.faranjit.hilt.mvvm.databinding.ItemListAllServicesBinding

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class AllServicesAdapter(
    private val serviceItemClickListener: ServiceItemClickListener
) :
    BaseAdapter<AllServiceItem, ItemListAllServicesBinding, AllServicesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllServicesViewHolder {
        val binding = DataBindingUtil.inflate<ItemListAllServicesBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_list_all_services,
            parent,
            false
        )

        return AllServicesViewHolder(binding, serviceItemClickListener)
    }
}