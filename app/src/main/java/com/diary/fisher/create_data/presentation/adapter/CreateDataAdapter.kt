package com.diary.fisher.create_data.presentation.adapter

import android.view.ViewGroup
import com.diary.fisher.R
import com.diary.fisher.core.ui.adapter.BaseAdapter
import com.diary.fisher.core.ui.adapter.BaseViewHolder
import com.diary.fisher.core.ui.adapter.MultipleTypesAdapter
import com.diary.fisher.report_add.models.ReportViewItem
import kotlinx.android.synthetic.main.item_list_water.view.*

class CreateDataAdapter() : MultipleTypesAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return SingleChoiceViewHolder(
            parent
        )
    }
}

class SingleChoiceViewHolder constructor(
    parent: ViewGroup
) : BaseViewHolder<ReportViewItem>(parent, R.layout.item_list_report, null) {
    override fun onBindElement(item: ReportViewItem) {
        itemView.tvWaterName.text = item.waterName
    }
}
