package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.rod.Rod
import com.diary.fisher.repository.interfaces.RodRepository

class CreateSingleLineRodUseCase(
    selectedItemId: Long,
    private val rodRepository: RodRepository
) : CreateSingleLineDataUseCase(selectedItemId) {

    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return rodRepository.getRodById(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return rodRepository.insertRod(Rod(dbId, singleLineText))
    }
}