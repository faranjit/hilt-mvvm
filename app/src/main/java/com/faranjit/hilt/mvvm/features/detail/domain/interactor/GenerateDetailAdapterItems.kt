package com.faranjit.hilt.mvvm.features.detail.domain.interactor

import com.faranjit.hilt.mvvm.R
import com.faranjit.hilt.mvvm.features.detail.domain.model.ServiceDetailModel
import com.faranjit.hilt.mvvm.features.detail.presentation.adapter.DetailItem

/**
 * Created by Bulent Turkmen on 10.10.2021.
 */
object GenerateDetailAdapterItems {

    fun generate(detailModel: ServiceDetailModel) =
        listOf(
            DetailItem(
                "${detailModel.proCount} pros near you",
                detailModel.proCount.toString(),
                R.drawable.ic_icn_profesyonel_number_orange
            ),
            DetailItem(
                "${detailModel.averageRating} average rating",
                detailModel.averageRating.toString(),
                R.drawable.ic_icn_star_average
            ),
            DetailItem(
                "Last month ${detailModel.jobCountOnLastMonth} jobs completed",
                detailModel.jobCountOnLastMonth.toString(),
                R.drawable.ic_icn_job_done_orange
            ),
            DetailItem(
                "Free of charge",
                null,
                R.drawable.ic_icn_ucretsiz_kullan_orange
            ),
            DetailItem(
                "Service guaranteed",
                null,
                R.drawable.ic_icn_hizmet_garanti_orange
            )
        )
}