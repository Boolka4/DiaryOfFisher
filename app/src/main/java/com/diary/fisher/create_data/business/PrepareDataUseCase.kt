package com.diary.fisher.create_data.business

import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem

interface PrepareDataUseCase {

    suspend fun getItemsList(): List<MultipleTypesViewItem>
}