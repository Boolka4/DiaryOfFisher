package com.diary.fisher.create_data.business

import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult


interface ProcessCreateItemsUseCase {
    fun processCreateItems(createDataItem: CreateDataItem): ProcessCreateItemClickResult
}