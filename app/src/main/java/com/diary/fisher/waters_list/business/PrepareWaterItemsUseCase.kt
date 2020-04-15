package com.diary.fisher.waters_list.business

import com.diary.fisher.repository.interfaces.WaterRepository
import com.diary.fisher.waters_list.models.WaterViewItem

class PrepareWaterItemsUseCase(private val waterRepository: WaterRepository) {

    suspend fun getItemsList(): List<WaterViewItem> {
        return waterRepository.getWatersList()
            .map { WaterViewItem() }
    }
}