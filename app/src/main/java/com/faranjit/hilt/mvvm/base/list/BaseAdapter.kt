package com.faranjit.hilt.mvvm.base.list

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
abstract class BaseAdapter<Item : BaseListItem<Item>, VB : ViewDataBinding, VH : BaseViewHolder<Item, VB>> :
    ListAdapter<Item, VH>(
        BaseRecyclerItemCallback<Item>()
    ) {

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}