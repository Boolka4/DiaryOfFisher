package com.diary.fisher.create_data.models

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem

sealed class ProcessCreateItemClickResult {

    object Nothing : ProcessCreateItemClickResult()

    data class UpdateList(val itemsList: List<MultipleTypesViewItem>) :
        ProcessCreateItemClickResult()

    data class NavigationScreen(
        val createDataType: CreateDataType,
        val canBeSaved: Boolean,
        val canBeAdded: Boolean,
        val useDividerDecorator: Boolean,
        val elementId: Long
    ) : ProcessCreateItemClickResult()

    data class NavigationDialog(
        val createDataType: CreateDataType,
        val dialogTitle: String,
        val elementId: Long
    ) : ProcessCreateItemClickResult()
}