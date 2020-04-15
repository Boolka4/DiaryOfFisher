package com.diary.fisher.core.ui.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var items: MutableList<ListItem> = mutableListOf()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return if (items.isNullOrEmpty()) {
            RecyclerView.NO_ID
        } else {
            items[position].getItemId()
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        holder.bindWithItem(getListItem(position))
    }


    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(newItems: List<ListItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    private fun getListItem(position: Int): ListItem {
        return items[position]
    }
}
