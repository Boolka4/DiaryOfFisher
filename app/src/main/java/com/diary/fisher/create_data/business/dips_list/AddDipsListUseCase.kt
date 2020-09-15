package com.diary.fisher.create_data.business.dips_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.DipStringsProvider

class AddDipsListUseCase(private val dipStringsProvider: DipStringsProvider) : AddDataUseCase {

    override fun processAddDataClick(): ProcessCreateItemClickResult {
        return ProcessCreateItemClickResult.NavigationDialog(
            createDataType = CreateDataType.CREATE_DIP,
            elementId = -1,
            dialogTitle = dipStringsProvider.getCreateDipDialogTitle()
        )
    }
}