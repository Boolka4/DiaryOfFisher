package com.diary.fisher.create_data.business.directions_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.repository.interfaces.DirectionRepository

class PrepareDirectionsListUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val directionRepository: DirectionRepository
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val directionsList = directionRepository.getDirectionsList()

        val itemsList = mutableListOf<CreateDataItem>()
        directionsList.sortedBy { it.directionId }
        directionsList.forEach { direction ->
            itemsList.add(
                CreateDataItem.SelectDataItem(
                    elementId = direction.directionId,
                    selectedItemId = direction.directionId,
                    isMandatory = false,
                    text = direction.brandName,
                    createDataType = CreateDataType.DIRECTIONS_LIST
                )
            )
        }
        return itemsList
    }

}