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
        val hintText: String,
        var currentValue: String
    ) : CreateDataItem(elementId, INPUT_FIELD_DATA_VIEW_TYPE)

    data class SelectDataItem(
        val elementId: Long,
        val selectedItemId: Long,
        val isMandatory: Boolean,
        val text: String
    ) : CreateDataItem(elementId, SELECT_DATA_DATA_VIEW_TYPE)

    data class SingleChoiceItem(
        val elementId: Long,
        val text: String,
        val isSelected: Boolean
    ) : CreateDataItem(elementId, SINGLE_CHOICE_DATA_VIEW_TYPE)

    companion object {
        const val INPUT_FIELD_DATA_VIEW_TYPE = 1
        const val SELECT_DATA_DATA_VIEW_TYPE = 2
        const val SINGLE_CHOICE_DATA_VIEW_TYPE = 3
    }
}

enum class InputFieldType {
    STRING, INT
}
