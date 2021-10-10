package com.faranjit.hilt.mvvm.features.home.presentation.adapter.all

import com.faranjit.hilt.mvvm.base.list.BaseViewHolder
import com.faranjit.hilt.mvvm.databinding.ItemListAllServicesBinding

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class AllServicesViewHolder(
    binding: ItemListAllServicesBinding,
    private val serviceItemClickListener: ServiceItemClickListener
) : BaseViewHolder<AllServiceItem, ItemListAllServicesBinding>(binding) {

    override fun bind(item: AllServiceItem) {
        binding.item = item
        if (item.id > 0) {
            binding.root.setOnClickListener {
                serviceItemClickListener.onServiceItemClick(item)
            }
        }
    }
}