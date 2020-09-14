package com.diary.fisher.create_data.business.directions_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.DirectionStringsProvider

class AddDirectionsListUseCase(private val directionStringsProvider: DirectionStringsProvider) :
    AddDataUseCase {

    override fun processAddDataClick(): ProcessCreateItemClickResult {
        return ProcessCreateItemClickResult.NavigationDialog(
            createDataType = CreateDataType.CREATE_DIRECTION,
            elementId = -1,
            dialogTitle = directionStringsProvider.getCreateDirectionDialogTitle()
        )
    }
}