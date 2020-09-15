package com.diary.fisher.create_data.business.baits_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.repository.interfaces.BaitRepository

class PrepareBaitsListUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val baitRepository: BaitRepository
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val baitsList = baitRepository.getBaitsList()

        val itemsList = mutableListOf<CreateDataItem>()
        baitsList.sortedBy { it.id }
        baitsList.forEach { direction ->
            itemsList.add(
                CreateDataItem.SelectDataItem(
                    elementId = direction.id,
                    selectedItemId = direction.id,
                    isMandatory = false,
                    text = direction.brandName,
                    createDataType = CreateDataType.BAITS_LIST
                )
            )
        }
        return itemsList
    }
}