package com.diary.fisher.db.converters

import androidx.room.TypeConverter
import com.diary.fisher.core.models.line.LineType
import com.diary.fisher.core.models.water.WaterType

class LineTypeConverter {

    @TypeConverter
    fun fromInt(value: Int): LineType {
        return when (value) {
            0 -> LineType.BRAIDED_CORD
            1 -> LineType.MONOLINE
            else -> LineType.FLUROCARBON
        }
    }

    @TypeConverter
    fun fromEnum(lineType: LineType): Int {
        return when (lineType) {
            LineType.BRAIDED_CORD -> 0
            LineType.MONOLINE -> 1
            LineType.FLUROCARBON -> 2
        }
    }
}