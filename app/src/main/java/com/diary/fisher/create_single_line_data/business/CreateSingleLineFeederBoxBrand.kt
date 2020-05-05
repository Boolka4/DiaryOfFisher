package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.feed_box.FeederBoxBrand
import com.diary.fisher.repository.interfaces.FeederBoxRepository

class CreateSingleLineFeederBoxBrand(
    private val feederBoxRepository: FeederBoxRepository
) : CreateSingleLineDataUseCase {

    override suspend fun createSingleLineData(singleLineText: String) {
        feederBoxRepository.insertFeederBoxBrand(FeederBoxBrand(0, singleLineText))
    }
}