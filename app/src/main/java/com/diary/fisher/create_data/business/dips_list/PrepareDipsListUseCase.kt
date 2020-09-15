package com.diary.fisher.create_data.business.dips_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.repository.interfaces.DipRepository

class PrepareDipsListUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val dipRepository: DipRepository
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val dipsList = dipRepository.getDipsList()

        val itemsList = mutableListOf<CreateDataItem>()
        dipsList.sortedBy { it.id }
        dipsList.forEach { direction ->
            itemsList.add(
                CreateDataItem.SelectDataItem(
                    elementId = direction.id,
                    selectedItemId = direction.id,
                    isMandatory = false,
                    text = direction.brandName,
                    createDataType = CreateDataType.DIPS_LIST
                )
            )
        }
        return itemsList
    }
}