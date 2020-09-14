package com.diary.fisher.core.models.common

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class CreateDataType : Parcelable {
    FEED_BOX,
    FEED_BOX_BRAND_NAME,
    HOOK_BRAND,
    ALL_SETTINGS_LIST,
    RODS_LIST,
    CREATE_ROD,
    DIRECTIONS_LIST,
    CREATE_DIRECTION,
    BITES_LIST,
    CREATE_BITE,
    DIPS_LIST,
    CREATE_DIP,
    FEEDS_LIST,
    CREATE_FEED,
    HOOK_PROTOTYPES_LIST,
    CREATE_HOOK_PROTOTYPE,
    MOUNTINGS_LIST,
    CREATE_MOUNTING

}