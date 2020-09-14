package com.diary.fisher.create_data.business.rod_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.repository.interfaces.RodRepository

class PrepareRodsListUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val rodRepository: RodRepository
) :
    BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val rodsList = rodRepository.getRodsList()
        val itemsList = mutableListOf<CreateDataItem>()
        rodsList.sortedBy { it.id }
        rodsList.forEachIndexed { index, rod ->
            itemsList.add(
                CreateDataItem.SelectDataItem(
                    elementId = rod.id,
                    selectedItemId = rod.id,
                    isMandatory = false,
                    text = rod.brandName,
                    createDataType = CreateDataType.RODS_LIST
                )
            )
        }
        return itemsList
    }
}