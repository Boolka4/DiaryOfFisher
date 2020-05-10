package com.diary.fisher.create_data.business

import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult


interface ProcessCreateItemsUseCase {

    fun processCreateItems(createDataItem: CreateDataItem): ProcessCreateItemClickResult

    fun processTextInserted(createDataItem: CreateDataItem.InputFieldDataItem, text: String)

    suspend fun processCreateDataResult(elementId: Long, resultId: Long): List<MultipleTypesViewItem>
}