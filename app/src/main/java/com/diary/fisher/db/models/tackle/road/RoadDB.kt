package com.diary.fisher.db.models.tackle.road

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoadDB(
    @PrimaryKey(autoGenerate = true) val roadId: Long = 0,
    val brandName: String,
    val roadSize: Double,
    val defaultQuivertip: Double
)