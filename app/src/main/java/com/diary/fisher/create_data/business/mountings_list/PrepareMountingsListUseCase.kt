package com.diary.fisher.create_data.business.mountings_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.repository.interfaces.MountingRepository

class PrepareMountingsListUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val mountingRepository: MountingRepository
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val mountingsList = mountingRepository.getMountingsList()

        val itemsList = mutableListOf<CreateDataItem>()
        mountingsList.sortedBy { it.mountingId }
        mountingsList.forEach { direction ->
            itemsList.add(
                CreateDataItem.SelectDataItem(
                    elementId = direction.mountingId,
                    selectedItemId = direction.mountingId,
                    isMandatory = false,
                    text = direction.brandName,
                    createDataType = CreateDataType.MOUNTINGS_LIST
                )
            )
        }
        return itemsList
    }
}