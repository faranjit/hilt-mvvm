package com.faranjit.hilt.mvvm.features.detail.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.faranjit.hilt.mvvm.R
import com.faranjit.hilt.mvvm.base.list.BaseAdapter
import com.faranjit.hilt.mvvm.databinding.ItemListDetailsBinding

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
class DetailAdapter : BaseAdapter<DetailItem, ItemListDetailsBinding, DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder =
        DetailViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_list_details,
                parent,
                false
            )
        )
}