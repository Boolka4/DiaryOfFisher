package com.diary.fisher.db.converters.feed_box

import androidx.room.TypeConverter
import com.diary.fisher.core.models.feed_box.FeedBoxForm

class FeedBoxFormTypeConverter {

    @TypeConverter
    fun fromInt(value: Int): FeedBoxForm {
        return when (value) {
            0 -> FeedBoxForm.DEFAULT
            1 -> FeedBoxForm.DUSE
            2 -> FeedBoxForm.BULLET
            else -> FeedBoxForm.FLAT
        }
    }

    @TypeConverter
    fun fromEnum(feedBoxForm: FeedBoxForm): Int {
        return when (feedBoxForm) {
            FeedBoxForm.DEFAULT -> 0
            FeedBoxForm.DUSE -> 1
            FeedBoxForm.BULLET -> 2
            FeedBoxForm.FLAT -> 3
        }
    }
}