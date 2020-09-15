package com.diary.fisher.create_data.business.hook_prototypes_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.CreateDataItemsHolder
import com.diary.fisher.repository.interfaces.HookPrototypeRepository

class PrepareHookPrototypesListUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val hookPrototypeRepository: HookPrototypeRepository
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val hookPrototypesList = hookPrototypeRepository.getHookPrototypesList()

        val itemsList = mutableListOf<CreateDataItem>()
        hookPrototypesList.sortedBy { it.hookPrototypeId }
        hookPrototypesList.forEach { direction ->
            itemsList.add(
                CreateDataItem.SelectDataItem(
                    elementId = direction.hookPrototypeId,
                    selectedItemId = direction.hookPrototypeId,
                    isMandatory = false,
                    text = direction.brandName,
                    createDataType = CreateDataType.HOOK_PROTOTYPES_LIST
                )
            )
        }
        return itemsList
    }
}