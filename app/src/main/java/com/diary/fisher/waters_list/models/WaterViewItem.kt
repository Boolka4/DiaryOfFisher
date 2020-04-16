package com.diary.fisher.waters_list.models

import com.diary.fisher.core.ui.adapter.ListItem

class WaterViewItem(
    val id: Long,
    val waterName: String,
    val distance: String,
    val reportsCount: Long,
    val rating: Double
) : ListItem {
    override fun getItemId(): Long {
        return id
    }

}