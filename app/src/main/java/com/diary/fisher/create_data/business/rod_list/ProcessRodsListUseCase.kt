package com.diary.fisher.create_data.business.rod_list

import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import com.diary.fisher.create_data.business.ProcessCreateItemsUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult

class ProcessRodsListUseCase() : ProcessCreateItemsUseCase {
    override fun processCreateItems(createDataItem: CreateDataItem): ProcessCreateItemClickResult {
        return ProcessCreateItemClickResult.Nothing
    }

    override fun processTextInserted(
        createDataItem: CreateDataItem.InputFieldDataItem,
        text: String
    ) {
    }

    override suspend fun processCreateDataResult(
        elementId: Long,
        resultId: Long
    ): List<MultipleTypesViewItem> {
        return emptyList()
    }
}