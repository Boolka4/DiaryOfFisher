package com.diary.fisher.waters_list.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.diary.fisher.R
import com.diary.fisher.core.ui.adapter.BaseAdapter
import com.diary.fisher.core.ui.adapter.BaseViewHolder
import com.diary.fisher.core.ui.adapter.ListItem
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
