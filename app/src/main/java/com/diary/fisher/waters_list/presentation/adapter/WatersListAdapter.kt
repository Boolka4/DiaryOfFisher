package com.diary.fisher.waters_list.presentation.adapter

import android.view.ViewGroup
import com.diary.fisher.R
import com.diary.fisher.core.ui.adapter.BaseAdapter
import com.diary.fisher.core.ui.adapter.BaseViewHolder
import com.diary.fisher.waters_list.models.WaterViewItem

class WatersListAdapter(
    private val onWaterClickListener: (WaterViewItem) -> Unit
) : BaseAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return WaterViewHolder(onWaterClickListener, parent)
    }
}

class WaterViewHolder constructor(
    onWaterClickListener: (WaterViewItem) -> Unit,
    parent: ViewGroup
) : BaseViewHolder<WaterViewItem>(parent, R.layout.item_list_water, onWaterClickListener) {
    override fun onBindElement(item: WaterViewItem) {
    }
}
