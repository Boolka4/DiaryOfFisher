package com.diary.fisher.create_data.business

import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.CreateDataItemsHolder

abstract class BasePrepareDataUseCase(private val createDataItemsHolder: CreateDataItemsHolder) :
    PrepareDataUseCase {

    override suspend fun getItemsList(): List<MultipleTypesViewItem> {
        val generatedItemsList = generateItemsList()
        createDataItemsHolder.crateDataList = generatedItemsList
        return generatedItemsList
    }

    abstract suspend fun generateItemsList(): List<CreateDataItem>
}