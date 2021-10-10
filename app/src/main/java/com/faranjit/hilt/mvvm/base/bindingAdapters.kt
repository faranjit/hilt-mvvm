package com.faranjit.hilt.mvvm.base

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.faranjit.hilt.mvvm.R
import com.faranjit.hilt.mvvm.di.GlideApp
import com.faranjit.hilt.mvvm.features.detail.domain.interactor.makeSpannable

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@BindingAdapter("visibility")
fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter(value = ["url", "imageRadius"], requireAll = false)
fun setImageUrl(view: AppCompatImageView, url: String?, radius: Int? = null) {
    if (url.isNullOrEmpty()) {
        return
    } else {
        val request = GlideApp.with(view.context)
            .load(url)
            .centerCrop()

        radius?.let {
            if (it > 0) {
                request.apply(RequestOptions.bitmapTransform(RoundedCorners(it)))
            }
        }

        request.into(view)
    }
}

@BindingAdapter("android:src")
fun setImageSource(view: AppCompatImageView, resId: Int) {
    view.setImageResource(resId)
}

@BindingAdapter("span")
fun makeSpannable(view: AppCompatTextView, span: String?) {
    span?.let {
        val text = view.text.toString()
        val spanned = text.makeSpannable(
            ContextCompat.getColor(view.context, R.color.green),
            span
        )

        view.text = spanned
    }
}