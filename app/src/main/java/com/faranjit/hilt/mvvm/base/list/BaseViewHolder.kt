package com.faranjit.hilt.mvvm.base.list

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
abstract class BaseViewHolder<Item : BaseListItem<Item>, VB : ViewDataBinding>(
    val binding: VB
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: Item)
}