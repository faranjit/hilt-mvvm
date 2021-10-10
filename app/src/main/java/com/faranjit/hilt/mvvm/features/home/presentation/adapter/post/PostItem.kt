package com.faranjit.hilt.mvvm.features.home.presentation.adapter.post

import com.faranjit.hilt.mvvm.base.list.BaseListItem
import com.faranjit.hilt.mvvm.features.home.data.response.Post

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
data class PostItem(
    val title: String,
    val category: String?,
    val imageUrl: String?,
    val link: String?
) : BaseListItem<PostItem> {

    override fun areItemsTheSame(newItem: PostItem) = title == newItem.title

    override fun areContentsTheSame(newItem: PostItem) = this == newItem
}

fun List<Post>.mapToPostItems() = this.map {
    PostItem(it.title, it.category, it.imageUrl, it.link)
}