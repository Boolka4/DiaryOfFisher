package com.diary.fisher.db.models.line

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diary.fisher.core.models.line.LineType


@Entity
data class LineDiameterDB(
    @PrimaryKey(autoGenerate = true) val lineId: Long = 0,
    val lineBrandId: Long,
    val diameter: Double,
    val type: LineType
)
