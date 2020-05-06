package com.diary.fisher.db.converters.feed_box

import androidx.room.TypeConverter
import com.diary.fisher.core.models.feed_box.FeedBoxMountingType

class FeedBoxMountingConverter {

    @TypeConverter
    fun fromInt(value: Int): FeedBoxMountingType {
        return when (value) {
            0 -> FeedBoxMountingType.DEFAULT
            1 -> FeedBoxMountingType.LINE
            else -> FeedBoxMountingType.IN_LINE
        }
    }

    @TypeConverter
    fun fromEnum(feedBoxMountingType: FeedBoxMountingType): Int {
        return when (feedBoxMountingType) {
            FeedBoxMountingType.DEFAULT -> 0
            FeedBoxMountingType.LINE -> 1
            FeedBoxMountingType.IN_LINE -> 2
        }
    }
}