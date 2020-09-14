package com.diary.fisher.create_data.business.rod_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.AddRodsStringsProvider

class AddRodsListUseCase(private val addRodsStringsProvider: AddRodsStringsProvider) :
    AddDataUseCase {

    override fun processAddDataClick(): ProcessCreateItemClickResult {
        return ProcessCreateItemClickResult.NavigationDialog(
            createDataType = CreateDataType.CREATE_ROD,
            elementId = -1,
            dialogTitle = addRodsStringsProvider.getCreateRodDialogTitle()
        )
    }
}