package com.diary.fisher.select_item_dialog.presentation.adapter

import android.view.ViewGroup
import com.diary.fisher.R
import com.diary.fisher.core.ui.adapter.BaseAdapter
import com.diary.fisher.core.ui.adapter.BaseViewHolder
import com.diary.fisher.select_item_dialog.models.SelectSingleViewItem
import kotlinx.android.synthetic.main.item_list_select_single.view.*

class SelectSingleItemAdapter(private val onSelectSingleViewItemClicked: (SelectSingleViewItem) -> Unit) :
    BaseAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return SelectSingleItemViewHolder(onSelectSingleViewItemClicked, parent)
    }
}

class SelectSingleItemViewHolder constructor(
    onSelectSingleViewItemClicked: (SelectSingleViewItem) -> Unit,
    parent: ViewGroup
) : BaseViewHolder<SelectSingleViewItem>(
    parent,
    R.layout.item_list_select_single,
    onSelectSingleViewItemClicked
) {
    override fun onBindElement(item: SelectSingleViewItem) {
        itemView.tvItemText.text = item.text
    }
}
