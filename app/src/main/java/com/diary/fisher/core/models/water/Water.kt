package com.diary.fisher.core.models.water

import com.diary.fisher.db.models.WaterType

data class Water(
    val id: Long,
    val name: String,
    val region: String,
    val distance: Long,
    val type: WaterType
)