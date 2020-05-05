package com.diary.fisher.select_item_dialog.models

import com.diary.fisher.core.ui.adapter.ListItem

class SelectSingleViewItem(
    val id: Long,
    val text: String
) : ListItem {
    override fun getItemId(): Long {
        return id
    }
}