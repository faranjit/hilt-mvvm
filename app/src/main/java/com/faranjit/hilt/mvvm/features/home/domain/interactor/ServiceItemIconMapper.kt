package com.faranjit.hilt.mvvm.features.home.domain.interactor

import com.faranjit.hilt.mvvm.R

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
object ServiceItemIconMapper {

    private val images = mapOf(
        208 to R.drawable.ic_tadilat,
        191 to R.drawable.ic_temizlik,
        142 to R.drawable.ic_nakliyat,
        533 to R.drawable.ic_tamir,
        608 to R.drawable.ic_ozel_ders,
        51457 to R.drawable.ic_saglik,
        59 to R.drawable.ic_dugun,
        -1 to R.drawable.ic_diger,
    )

    fun getServiceIcon(id: Int) = images[id] ?: R.drawable.ic_diger
}