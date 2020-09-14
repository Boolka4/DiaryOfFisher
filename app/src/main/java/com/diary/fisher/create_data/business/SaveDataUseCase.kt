package com.diary.fisher.create_data.business

import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem

interface SaveDataUseCase {

    suspend fun saveData(data: List<MultipleTypesViewItem>)
}