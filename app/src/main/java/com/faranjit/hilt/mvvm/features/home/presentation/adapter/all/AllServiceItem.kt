package com.faranjit.hilt.mvvm.features.home.presentation.adapter.all

import androidx.annotation.DrawableRes
import com.faranjit.hilt.mvvm.base.list.BaseListItem
import com.faranjit.hilt.mvvm.features.home.data.response.Service
import com.faranjit.hilt.mvvm.features.home.domain.interactor.ServiceItemIconMapper

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
data class AllServiceItem(
    val name: String,
    @DrawableRes val resId: Int
) : BaseListItem<AllServiceItem> {

    override fun areItemsTheSame(newItem: AllServiceItem) = name == newItem.name

    override fun areContentsTheSame(newItem: AllServiceItem) = this == newItem
}

fun List<Service>.mapToAllServiceItems() = this.map {
    AllServiceItem(it.name, ServiceItemIconMapper.getServiceIcon(it.id))
}