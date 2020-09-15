package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.dip.Dip
import com.diary.fisher.repository.interfaces.DipRepository

class CreateSingleLineDipUseCase(
    selectItemId: Long,
    private val dipRepository: DipRepository
) : CreateSingleLineDataUseCase(selectItemId) {

    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return dipRepository.getDipById(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return dipRepository.insertDip(Dip(dbId, singleLineText))
    }
}