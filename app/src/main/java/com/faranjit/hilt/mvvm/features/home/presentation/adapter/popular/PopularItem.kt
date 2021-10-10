package com.faranjit.hilt.mvvm.features.home.presentation.adapter.popular

import com.faranjit.hilt.mvvm.base.list.BaseListItem
import com.faranjit.hilt.mvvm.features.home.data.response.Service

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
data class PopularItem(
    override val id: Int,
    val name: String,
    val imageUrl: String?
) : BaseListItem<PopularItem> {

    override fun areItemsTheSame(newItem: PopularItem) = id == newItem.id

    override fun areContentsTheSame(newItem: PopularItem) = this == newItem
}

fun List<Service>.mapToPopularItems() = this.map {
    PopularItem(it.id, it.name, it.imageUrl)
}