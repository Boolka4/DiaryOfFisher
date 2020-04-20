package com.diary.fisher.db.converters

import androidx.room.TypeConverter
import com.diary.fisher.core.models.water.WaterType
import com.diary.fisher.core.models.water.WaterType.*

class WaterTypeConverter {

    @TypeConverter
    fun fromInt(value: Int): WaterType {
        return when (value) {
            0 -> RIVER
            1 -> LAKE
            else -> CHANNEL
        }
    }

    @TypeConverter
    fun fromEnum(waterType: WaterType): Int {
        return when (waterType) {
            RIVER -> 0
            LAKE -> 1
            CHANNEL -> 2
        }
    }
}