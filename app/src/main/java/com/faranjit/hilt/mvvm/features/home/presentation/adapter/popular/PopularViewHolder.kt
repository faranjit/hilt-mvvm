package com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular

import com.faranjit.hilt.mvvm.base.list.BaseViewHolder
import com.faranjit.hilt.mvvm.databinding.ItemListPopularBinding

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class PopularViewHolder(
    binding: ItemListPopularBinding
) : BaseViewHolder<PopularItem, ItemListPopularBinding>(binding) {

    override fun bind(item: PopularItem) {
        binding.item = item
    }
}