package com.faranjit.hilt.mvvm.features.detail.presentation.adapter

import com.faranjit.hilt.mvvm.base.list.BaseViewHolder
import com.faranjit.hilt.mvvm.databinding.ItemListDetailsBinding

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
class DetailViewHolder(
    binding: ItemListDetailsBinding
) : BaseViewHolder<DetailItem, ItemListDetailsBinding>(binding) {

    override fun bind(item: DetailItem) {
        binding.item = item
    }
}