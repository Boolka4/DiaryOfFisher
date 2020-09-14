package com.diary.fisher.create_data.business.all_settings_list

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem
import com.diary.fisher.create_data.business.ProcessCreateItemsUseCase
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.ProcessCreateItemClickResult

class ProcessAllSettingsListUseCase() : ProcessCreateItemsUseCase {

    override fun processItemClick(createDataItem: CreateDataItem): ProcessCreateItemClickResult {

        return when ((createDataItem as CreateDataItem.SelectDataItem).createDataType) {
            CreateDataType.RODS_LIST -> {
                ProcessCreateItemClickResult.NavigationScreen(
                    createDataType = CreateDataType.RODS_LIST,
                    canBeSaved = false,
                    canBeAdded = true,
                    useDividerDecorator = true,
                    elementId = createDataItem.elementId
                )
            }
            CreateDataType.DIRECTIONS_LIST -> {
                ProcessCreateItemClickResult.NavigationScreen(
                    createDataType = CreateDataType.DIRECTIONS_LIST,
                    canBeSaved = false,
                    canBeAdded = false,
                    useDividerDecorator = false,
                    elementId = createDataItem.elementId
                )
            }
            CreateDataType.BITES_LIST -> {
                ProcessCreateItemClickResult.NavigationScreen(
                    createDataType = CreateDataType.RODS_LIST,
                    canBeSaved = false,
                    canBeAdded = false,
                    useDividerDecorator = false,
                    elementId = createDataItem.elementId
                )
            }
            CreateDataType.DIPS_LIST -> {
                ProcessCreateItemClickResult.NavigationScreen(
                    createDataType = CreateDataType.RODS_LIST,
                    canBeSaved = false,
                    canBeAdded = false,
                    useDividerDecorator = false,
                    elementId = createDataItem.elementId
                )
            }
            CreateDataType.FEEDS_LIST -> {
                ProcessCreateItemClickResult.NavigationScreen(
                    createDataType = CreateDataType.RODS_LIST,
                    canBeSaved = false,
                    canBeAdded = false,
                    useDividerDecorator = false,
                    elementId = createDataItem.elementId
                )
            }
            CreateDataType.HOOK_PROTOTYPES_LIST -> {
                ProcessCreateItemClickResult.NavigationScreen(
                    createDataType = CreateDataType.RODS_LIST,
                    canBeSaved = false,
                    canBeAdded = false,
                    useDividerDecorator = false,
                    elementId = createDataItem.elementId
                )
            }
            CreateDataType.MOUNTINGS_LIST -> {
                ProcessCreateItemClickResult.NavigationScreen(
                    createDataType = CreateDataType.RODS_LIST,
                    canBeSaved = false,
                    canBeAdded = false,
                    useDividerDecorator = false,
                    elementId = createDataItem.elementId
                )
            }
            else -> {
                ProcessCreateItemClickResult.Nothing
            }
        }

    }

    override fun processTextInserted(
        createDataItem: CreateDataItem.InputFieldDataItem,
        text: String
    ) {
    }
}