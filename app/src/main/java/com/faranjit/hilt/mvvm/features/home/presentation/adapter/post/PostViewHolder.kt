package com.faranjit.hilt.mvvm.features.home.presentation.adapter.post

import com.faranjit.hilt.mvvm.base.list.BaseViewHolder
import com.faranjit.hilt.mvvm.databinding.ItemListPostsBinding

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class PostViewHolder(
    binding: ItemListPostsBinding,
    private val clickListener: PostClickListener
) : BaseViewHolder<PostItem, ItemListPostsBinding>(binding) {

    override fun bind(item: PostItem) {
        binding.item = item
        binding.imgPost.setOnClickListener {
            clickListener.onPostClick(item)
        }
    }
}