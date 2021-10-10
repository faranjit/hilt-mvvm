package com.faranjit.hilt.mvvm.features.home.presentation.adapter.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.faranjit.hilt.mvvm.R
import com.faranjit.hilt.mvvm.base.list.BaseAdapter
import com.faranjit.hilt.mvvm.databinding.ItemListPostsBinding

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
class PostAdapter(
    private val clickListener: PostClickListener
) : BaseAdapter<PostItem, ItemListPostsBinding, PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = DataBindingUtil.inflate<ItemListPostsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_list_posts,
            parent,
            false
        )

        return PostViewHolder(binding, clickListener)
    }
}