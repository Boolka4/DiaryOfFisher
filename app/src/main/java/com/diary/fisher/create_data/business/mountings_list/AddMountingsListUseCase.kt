package com.diary.fisher.create_data.business.mountings_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.MountingStringsProvider

class AddMountingsListUseCase(private val mountingStringsProvider: MountingStringsProvider) :
    AddDataUseCase {

    override fun processAddDataClick(): ProcessCreateItemClickResult {
        return ProcessCreateItemClickResult.NavigationDialog(
            createDataType = CreateDataType.CREATE_MOUNTING,
            elementId = -1,
            dialogTitle = mountingStringsProvider.getCreateMountingDialogTitle()
        )
    }
}