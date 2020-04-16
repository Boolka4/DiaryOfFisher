package com.diary.fisher.report_add.models

import com.diary.fisher.core.ui.adapter.ListItem

class ReportViewItem(
    val id: Long,
    val waterName: String
) : ListItem {
    override fun getItemId(): Long {
        return id
    }

}