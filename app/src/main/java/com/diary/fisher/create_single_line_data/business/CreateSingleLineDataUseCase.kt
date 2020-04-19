package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.hook.HookBrand
import com.diary.fisher.repository.interfaces.HookRepository

class CreateSingleLineDataUseCase(private val hookRepository: HookRepository) {

    suspend fun createHookBrand(brandName: String) {
        if (brandName.isNotEmpty()) {
            hookRepository.insertHookBrand(HookBrand(0, brandName))
        }
    }
}