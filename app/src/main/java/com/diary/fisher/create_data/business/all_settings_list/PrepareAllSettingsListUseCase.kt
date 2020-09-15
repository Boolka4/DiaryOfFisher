package com.diary.fisher.create_data.business.all_settings_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.create_data.business.BasePrepareDataUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.rep.AllSettingsListStringsProvider
import com.diary.fisher.create_data.rep.CreateDataItemsHolder

class PrepareAllSettingsListUseCase(
    createDataItemsHolder: CreateDataItemsHolder,
    private val allSettingsListStringsProvider: AllSettingsListStringsProvider
) : BasePrepareDataUseCase(createDataItemsHolder) {

    override suspend fun generateItemsList(): List<CreateDataItem> {
        val itemsList = mutableListOf<CreateDataItem>()
        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 1,
                selectedItemId = 1,
                isMandatory = false,
                text = allSettingsListStringsProvider.getRodsText(),
                createDataType = CreateDataType.RODS_LIST
            )
        )

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 2,
                selectedItemId = 2,
                isMandatory = false,
                text = allSettingsListStringsProvider.getDirectionsText(),
                createDataType = CreateDataType.DIRECTIONS_LIST
            )
        )
        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 3,
                selectedItemId = 3,
                isMandatory = false,
                text = allSettingsListStringsProvider.getBaitsText(),
                createDataType = CreateDataType.BAITS_LIST
            )
        )

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 4,
                selectedItemId = 4,
                isMandatory = false,
                text = allSettingsListStringsProvider.getDipsText(),
                createDataType = CreateDataType.DIPS_LIST
            )
        )

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 5,
                selectedItemId = 5,
                isMandatory = false,
                text = allSettingsListStringsProvider.getFeedsText(),
                createDataType = CreateDataType.FEEDS_LIST
            )
        )


        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 6,
                selectedItemId = 6,
                isMandatory = false,
                text = allSettingsListStringsProvider.getHooksText(),
                createDataType = CreateDataType.HOOK_PROTOTYPES_LIST
            )
        )

        itemsList.add(
            CreateDataItem.SelectDataItem(
                elementId = 7,
                selectedItemId = 7,
                isMandatory = false,
                text = allSettingsListStringsProvider.getMountingsText(),
                createDataType = CreateDataType.MOUNTINGS_LIST
            )
        )
        return itemsList
    }
}