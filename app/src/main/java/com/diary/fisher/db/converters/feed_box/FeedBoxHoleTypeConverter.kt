package com.diary.fisher.db.converters.feed_box

import androidx.room.TypeConverter
import com.diary.fisher.core.models.feed_box.FeedBoxHoleType

class FeedBoxHoleTypeConverter {

    @TypeConverter
    fun fromInt(value: Int): FeedBoxHoleType {
        return when (value) {
            0 -> FeedBoxHoleType.OPEN
            1 -> FeedBoxHoleType.MEDIUM
            else -> FeedBoxHoleType.CLOSED
        }
    }

    @TypeConverter
    fun fromEnum(feedBoxHoleType: FeedBoxHoleType): Int {
        return when (feedBoxHoleType) {
            FeedBoxHoleType.OPEN -> 0
            FeedBoxHoleType.MEDIUM -> 1
            FeedBoxHoleType.CLOSED -> 2
        }
    }
}
