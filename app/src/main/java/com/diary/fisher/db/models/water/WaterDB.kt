package com.diary.fisher.db.models.water

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diary.fisher.core.models.water.WaterType

@Entity
data class WaterDB(
    @PrimaryKey(autoGenerate = true) val waterId: Long = 0,
    val name: String,
    val region: String,
    val distance: Long,
    val type: WaterType
)