package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.hook.HookBrand
import com.diary.fisher.repository.interfaces.HookRepository

class CreateSingleLineHookBrandDataUseCase(
    selectedItemId: Long,
    private val hookRepository: HookRepository
) : CreateSingleLineDataUseCase(selectedItemId) {

    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return hookRepository.getHookBrand(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return hookRepository.insertHookBrand(HookBrand(dbId, singleLineText))
    }
}