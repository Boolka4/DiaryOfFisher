package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.hook_prototype.HookPrototype
import com.diary.fisher.repository.interfaces.HookPrototypeRepository

class CreateSingleLineHookPrototype(
    selectedItemId: Long,
    private val hookPrototypeRepository: HookPrototypeRepository
) : CreateSingleLineDataUseCase(selectedItemId) {

    override suspend fun loadDefaultNameFromRepository(selectedItemId: Long): String {
        return hookPrototypeRepository.getHookPrototypeById(selectedItemId).brandName
    }

    override suspend fun insertSingleLineElement(dbId: Long, singleLineText: String): Long {
        return hookPrototypeRepository.insertHookPrototype(HookPrototype(dbId, singleLineText))
    }
}