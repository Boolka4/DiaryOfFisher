package com.diary.fisher.core.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<T : ListItem>(
    parent: ViewGroup,
    @LayoutRes layout: Int,
    clickListener: ((T) -> Unit)? = null,
    longClickListener: ((T) -> Unit)? = null
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false)) {

    protected lateinit var currentItem: T

    init {
        clickListener?.let { itemView.setOnClickListener { clickListener(currentItem) } }
        longClickListener?.let {
            itemView.setOnLongClickListener {
                longClickListener(currentItem)
                return@setOnLongClickListener true
            }
        }
    }

    abstract fun onBindElement(item: T)

    fun bindWithItem(listItem: ListItem) {
        currentItem = listItem as T
        onBindElement(listItem)
    }
}
