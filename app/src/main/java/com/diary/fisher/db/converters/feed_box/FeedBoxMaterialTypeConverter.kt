package com.diary.fisher.db.converters.feed_box

import androidx.room.TypeConverter
import com.diary.fisher.core.models.feed_box.FeedBoxMaterialType

class FeedBoxMaterialTypeConverter {

    @TypeConverter
    fun fromInt(value: Int): FeedBoxMaterialType {
        return when (value) {
            0 -> FeedBoxMaterialType.METAL
            else -> FeedBoxMaterialType.PLASTIC
        }
    }

    @TypeConverter
    fun fromEnum(feedBoxMaterialType: FeedBoxMaterialType): Int {
        return when (feedBoxMaterialType) {
            FeedBoxMaterialType.METAL -> 0
            FeedBoxMaterialType.PLASTIC -> 1
        }
    }
}