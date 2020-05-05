package com.diary.fisher.repository.interfaces

import com.diary.fisher.core.models.feed_box.FeederBoxBrand

interface FeederBoxRepository {

    suspend fun insertFeederBoxBrand(feederBoxBrand: FeederBoxBrand)

    suspend fun getFeederBoxBrandsList(): List<FeederBoxBrand>
}