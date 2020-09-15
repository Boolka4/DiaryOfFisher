package com.diary.fisher.create_data.business.baits_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.BaitStringsProvider

class AddBaitsListUseCase(private val baitStringsProvider: BaitStringsProvider) :
    AddDataUseCase {

    override fun processAddDataClick(): ProcessCreateItemClickResult {
        return ProcessCreateItemClickResult.NavigationDialog(
            createDataType = CreateDataType.CREATE_BAIT,
            elementId = -1,
            dialogTitle = baitStringsProvider.getCreateBaitDialogTitle()
        )
    }
}