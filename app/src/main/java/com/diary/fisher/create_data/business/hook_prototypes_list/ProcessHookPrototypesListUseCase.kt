package com.diary.fisher.create_data.business.hook_prototypes_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.ProcessCreateItemsUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.HookPrototypesStringsProvider

class ProcessHookPrototypesListUseCase(private val hookPrototypesStringsProvider: HookPrototypesStringsProvider) :
    ProcessCreateItemsUseCase {

    override fun processItemClick(createDataItem: CreateDataItem): ProcessCreateItemClickResult {

        return if (createDataItem is CreateDataItem.SelectDataItem) {
            ProcessCreateItemClickResult.NavigationDialog(
                createDataType = CreateDataType.CREATE_HOOK_PROTOTYPE,
                dialogTitle = hookPrototypesStringsProvider.getCreateHookPrototypeDialogTitle(),
                elementId = createDataItem.elementId
            )
        } else {
            ProcessCreateItemClickResult.Nothing
        }
    }

    override fun processTextInserted(
        createDataItem: CreateDataItem.InputFieldDataItem,
        text: String
    ) {
    }
}