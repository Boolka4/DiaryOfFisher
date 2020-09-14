package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.direction.Direction
import com.diary.fisher.repository.interfaces.DirectionRepository

class CreateSingleLineDirectionUseCase(
    selectedItemId: Long,
    private val directionRepository: DirectionRepository
) : CreateSingleLineDataUseCase(selectedItemId) {
    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return directionRepository.getDirectionById(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return directionRepository.insertDirection(Direction(dbId, singleLineText))
    }

}