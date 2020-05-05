package com.diary.fisher.create_data.models

import com.diary.fisher.core.ui.adapter.MultipleTypesViewItem

sealed class CreateDataItem(
    private val listItemId: Long,
    private val viewType: Int
) : MultipleTypesViewItem {

    override fun getItemId() = listItemId

    override fun getItemViewType() = viewType

    data class InputFieldDataItem(
        val elementId: Long,
        val isMandatory: Boolean,
        val inputType: InputFieldType,
        var currentValue: String
    ) : CreateDataItem(elementId, 1)

    data class SelectDataItem(
        val elementId: Long,
        val isMandatory: Boolean,
        val text: String
    ) : CreateDataItem(elementId, 2)

    data class SingleChoiceItem(
        val elementId: Long,
        val text: String,
        val isSelected: Boolean
    )
}

enum class InputFieldType {
    STRING, INT
}