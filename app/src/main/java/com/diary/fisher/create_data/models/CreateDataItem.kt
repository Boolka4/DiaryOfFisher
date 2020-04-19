package com.diary.fisher.create_data.models

sealed class CreateDataItem(val itemViewType: Int) {

    data class InputFieldDataItem(
        val elementId: Long,
        val isMandatory: Boolean,
        val inputType: InputFieldType,
        var currentValue: String
    ) : CreateDataItem(1)

    data class SelectDataItem(
        val elementId: Long,
        val isMandatory: Boolean
    ) : CreateDataItem(2)
}

enum class InputFieldType {
    STRING, INT
}