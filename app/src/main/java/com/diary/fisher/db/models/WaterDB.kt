package com.diary.fisher.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WaterDB(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val region: String,
    val distance: Long,
    val type: WaterType
)