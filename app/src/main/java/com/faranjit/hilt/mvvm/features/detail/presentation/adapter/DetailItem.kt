package com.faranjit.hilt.mvvm.features.detail.presentation.adapter

import androidx.annotation.DrawableRes
import com.faranjit.hilt.mvvm.base.list.BaseListItem

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
data class DetailItem(
    val text: String?,
    val span: String?,
    @DrawableRes val resId: Int
) : BaseListItem<DetailItem> {

    override val id: Int
        get() = 0

    override fun areItemsTheSame(newItem: DetailItem) = this == newItem

    override fun areContentsTheSame(newItem: DetailItem) = this == newItem
}