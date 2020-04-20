package com.diary.fisher.repository.implementation

import com.diary.fisher.core.models.water.Water
import com.diary.fisher.core.models.water.WaterType
import com.diary.fisher.repository.interfaces.WaterRepository

class WaterRepositoryFakeImpl : WaterRepository {

    override suspend fun saveWater(water: Water) {

    }

    override suspend fun getWaterByIds(id: Long): Water {
        return Water(0, "", "", 0, WaterType.LAKE)
    }

    override suspend fun getWatersList(): List<Water> {
        return mutableListOf(Water(1,"vileika","minsk",90,
            WaterType.LAKE))
    }
}