package com.faranjit.hilt.mvvm.features.detail.domain.interactor

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorInt

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
fun String?.makeSpannable(@ColorInt color: Int, spanText: String?): SpannableStringBuilder? {
    if (isNullOrEmpty() || spanText.isNullOrEmpty()) {
        return null
    }
    val start = this.indexOf(spanText)
    val end = start + spanText.length
    val spannable = SpannableStringBuilder(this)
    spannable.setSpan(
        ForegroundColorSpan(color),
        start,
        end,
        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
    )

    return spannable
}