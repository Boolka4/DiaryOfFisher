package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.water.Water

interface WaterRepository {

    suspend fun saveWater(water: Water)

    suspend fun getWaterByIds(id: Long): Water

    suspend fun getWatersList(): List<Water>
}