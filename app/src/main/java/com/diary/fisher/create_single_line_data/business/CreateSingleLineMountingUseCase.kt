package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.mounting.Mounting
import com.diary.fisher.repository.interfaces.MountingRepository

class CreateSingleLineMountingUseCase(
    selectItemId: Long,
    private val mountingRepository: MountingRepository
) : CreateSingleLineDataUseCase(selectItemId) {

    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return mountingRepository.getMountingById(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return mountingRepository.insertMounting(Mounting(dbId, singleLineText))
    }
}