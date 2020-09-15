package com.diary.fisher.create_data.business.hook_prototypes_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult
import com.diary.fisher.create_data.rep.HookPrototypesStringsProvider

class AddHookPrototypesListUseCase(private val hookPrototypesStringsProvider: HookPrototypesStringsProvider) :
    AddDataUseCase {

    override fun processAddDataClick(): ProcessCreateItemClickResult {
        return ProcessCreateItemClickResult.NavigationDialog(
            createDataType = CreateDataType.CREATE_HOOK_PROTOTYPE,
            elementId = -1,
            dialogTitle = hookPrototypesStringsProvider.getCreateHookPrototypeDialogTitle()
        )
    }
}