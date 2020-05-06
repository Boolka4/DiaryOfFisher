package com.diary.fisher.create_data.business

import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem

interface CreateDataUseCase {

    suspend fun createData(data: List<MultipleTypesViewItem>)
}