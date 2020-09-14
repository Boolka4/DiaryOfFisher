package com.diary.fisher.create_data.business.directions_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.ProcessCreateItemsUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.DirectionStringsProvider

class ProcessDirectionsListUseCase(private val directionStringsProvider: DirectionStringsProvider) :
    ProcessCreateItemsUseCase {

    override fun processItemClick(createDataItem: CreateDataItem): ProcessCreateItemClickResult {

        return if (createDataItem is CreateDataItem.SelectDataItem) {
            ProcessCreateItemClickResult.NavigationDialog(
                createDataType = CreateDataType.CREATE_DIRECTION,
                dialogTitle = directionStringsProvider.getCreateDirectionDialogTitle(),
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