package com.diary.fisher.create_data.models

import com.diary.fisher.core.models.common.CreateDataType
import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem

sealed class ProcessCreateItemClickResult {

    object Nothing : ProcessCreateItemClickResult()

    data class UpdateList(val itemsList: List<MultipleTypesViewItem>) :
        ProcessCreateItemClickResult()

    data class Navigation(
        val createDataType: CreateDataType,
        val navigationDestination: NavigationDestinationType,
        val elementId: Long
    ) : ProcessCreateItemClickResult()
}