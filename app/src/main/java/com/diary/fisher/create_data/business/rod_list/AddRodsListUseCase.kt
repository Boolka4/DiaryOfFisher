package com.diary.fisher.create_data.business.rod_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.AddDataUseCase
import com.diary.fisher.create_data.models.NavigationDestinationType
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult

class AddRodsListUseCase() : AddDataUseCase {

    override fun processAddDataClick(): ProcessCreateItemClickResult.Navigation {
        return ProcessCreateItemClickResult.Navigation(
            createDataType = CreateDataType.CREATE_ROD,
            navigationDestination = NavigationDestinationType.DIALOG,
            canBeSaved = false,
            canBeAdded = true,
            useDividerDecorator = true,
            elementId = -1
        )
    }
}