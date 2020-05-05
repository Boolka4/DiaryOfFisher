package com.diary.fisher.core.models.common

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class CreateDataType : Parcelable {
    FEED_BOX, FEED_BOX_BRAND_NAME
}