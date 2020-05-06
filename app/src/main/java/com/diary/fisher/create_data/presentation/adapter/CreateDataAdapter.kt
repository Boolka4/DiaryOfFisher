package com.diary.fisher.create_data.presentation.adapter

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.ViewGroup
import com.diary.fisher.R
import com.diary.fisher.core.ui.adapter.BaseAdapter
import com.diary.fisher.core.ui.adapter.BaseViewHolder
import com.diary.fisher.core.ui.adapter.MultipleTypesAdapter
import com.diary.fisher.create_data.models.CreateDataItem
import com.diary.fisher.create_data.models.CreateDataItem.Companion.INPUT_FIELD_DATA_VIEW_TYPE
import com.diary.fisher.create_data.models.CreateDataItem.Companion.SELECT_DATA_DATA_VIEW_TYPE
import com.diary.fisher.create_data.models.InputFieldType
import com.diary.fisher.report_add.models.ReportViewItem
import kotlinx.android.synthetic.main.item_list_input_field_data.view.*
import kotlinx.android.synthetic.main.item_list_single_choice.view.*
import kotlinx.android.synthetic.main.item_list_water.view.*

class CreateDataAdapter() : MultipleTypesAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            INPUT_FIELD_DATA_VIEW_TYPE -> InputFieldDataViewHolder(parent)
            SELECT_DATA_DATA_VIEW_TYPE -> SelectDataViewHolder(parent)
            else -> SingleChoiceViewHolder(parent)
        }
    }
}

class InputFieldDataViewHolder constructor(
    parent: ViewGroup
) : BaseViewHolder<CreateDataItem.InputFieldDataItem>(
    parent,
    R.layout.item_list_input_field_data,
    null
) {

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            //no op
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //no op
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            currentItem.currentValue = s?.toString() ?: ""
        }
    }

    init {
        itemView.etInput.addTextChangedListener(textWatcher)
    }

    override fun onBindElement(item: CreateDataItem.InputFieldDataItem) {
        when (item.inputType) {
            InputFieldType.STRING -> itemView.etInput.inputType = InputType.TYPE_CLASS_TEXT
            InputFieldType.INT -> itemView.etInput.inputType = InputType.TYPE_CLASS_NUMBER
        }
        itemView.etInput.setText(item.currentValue)
        itemView.etInput.hint = item.hintText
    }
}

class SelectDataViewHolder constructor(
    parent: ViewGroup
) : BaseViewHolder<CreateDataItem.SelectDataItem>(
    parent,
    R.layout.item_list_select_single_data,
    null
) {
    override fun onBindElement(item: CreateDataItem.SelectDataItem) {
    }
}

class SingleChoiceViewHolder constructor(
    parent: ViewGroup
) : BaseViewHolder<CreateDataItem.SingleChoiceItem>(
    parent,
    R.layout.item_list_single_choice,
    null
) {
    override fun onBindElement(item: CreateDataItem.SingleChoiceItem) {
        itemView.rbSingleChoice.text = item.text
        itemView.rbSingleChoice.isSelected = item.isSelected
    }
}
