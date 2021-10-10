package com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.faranjit.hilt.mvvm.R
import com.faranjit.hilt.mvvm.base.list.BaseAdapter
import com.faranjit.hilt.mvvm.databinding.ItemListPopularBinding

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class PopularAdapter(
    private val popularItemClickListener: PopularItemClickListener
) : BaseAdapter<PopularItem, ItemListPopularBinding, PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = DataBindingUtil.inflate<ItemListPopularBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_list_popular,
            parent,
            false
        )

        return PopularViewHolder(binding, popularItemClickListener)
    }
}