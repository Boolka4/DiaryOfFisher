package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.hook.HookBrand
import com.diary.fisher.repository.interfaces.HookRepository

class CreateSingleLineHookBrandDataUseCase(private val hookRepository: HookRepository) :
    CreateSingleLineDataUseCase {

    override suspend fun createSingleLineData(singleLineText: String) {
        if (singleLineText.isNotEmpty()) {
            hookRepository.insertHookBrand(HookBrand(0, singleLineText))
        }
    }
}