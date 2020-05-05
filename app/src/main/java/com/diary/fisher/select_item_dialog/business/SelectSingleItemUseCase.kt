package com.diary.fisher.select_item_dialog.business

import com.diary.fisher.repository.interfaces.HookRepository
import com.diary.fisher.select_item_dialog.models.SelectSingleViewItem

class SelectSingleItemUseCase(private val hookRepository: HookRepository) {

    suspend fun getItemsList(): List<SelectSingleViewItem> =
        hookRepository.getHooksBrandList().map { SelectSingleViewItem(it.id, it.brandName) }
}