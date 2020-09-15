package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.bait.Bait
import com.diary.fisher.repository.interfaces.BaitRepository

class CreateSingleLineBaitUseCase(
    selectedItemId: Long,
    private val baitRepository: BaitRepository
) : CreateSingleLineDataUseCase(selectedItemId) {

    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return baitRepository.getBaitById(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return baitRepository.insertBait(Bait(dbId, singleLineText))
    }
}