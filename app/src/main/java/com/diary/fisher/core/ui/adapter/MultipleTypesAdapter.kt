package com.diary.fisher.core.ui.adapter

abstract class MultipleTypesAdapter : BaseAdapter() {

    override fun getItemViewType(position: Int): Int {
        return (getListItem(position) as MultipleTypesViewItem).getItemViewType()
    }
}