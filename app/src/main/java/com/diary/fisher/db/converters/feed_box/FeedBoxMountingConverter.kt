package com.diary.fisher.db.converters.feed_box

import androidx.room.TypeConverter
import com.diary.fisher.core.models.feed_box.FeedBoxMounting

class FeedBoxMountingConverter {

    @TypeConverter
    fun fromInt(value: Int): FeedBoxMounting {
        return when (value) {
            0 -> FeedBoxMounting.DEFAULT
            1 -> FeedBoxMounting.LINE
            else -> FeedBoxMounting.IN_LINE
        }
    }

    @TypeConverter
    fun fromEnum(feedBoxMounting: FeedBoxMounting): Int {
        return when (feedBoxMounting) {
            FeedBoxMounting.DEFAULT -> 0
            FeedBoxMounting.LINE -> 1
            FeedBoxMounting.IN_LINE -> 2
        }
    }
}