package com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular

import com.faranjit.hilt.mvvm.base.list.BaseListItem
import com.faranjit.hilt.mvvm.features.home.data.response.Service

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
data class PopularItem(
    val name: String,
    val imageUrl: String?
) : BaseListItem<PopularItem> {

    override fun areItemsTheSame(newItem: PopularItem) = name == newItem.name

    override fun areContentsTheSame(newItem: PopularItem) = this == newItem
}

fun List<Service>.mapToPopularItems() = this.map {
    PopularItem(it.name, it.imageUrl)
}