package com.diary.fisher.create_single_line_data.business

import com.diary.fisher.core.models.common.Constants.Companion.NOT_SELECTED_ITEM_ID
import com.diary.fisher.core.models.hook.HookBrand
import com.diary.fisher.repository.interfaces.HookRepository

class CreateSingleLineHookBrandDataUseCase(private val hookRepository: HookRepository) :
    CreateSingleLineDataUseCase {

    override suspend fun createSingleLineData(singleLineText: String): Long {
        return if (singleLineText.isNotEmpty()) {
            hookRepository.insertHookBrand(HookBrand(0, singleLineText))
        } else {
            NOT_SELECTED_ITEM_ID
        }
    }
}