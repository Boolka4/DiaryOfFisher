package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class DirectionStringsProvider(private val resourceManager: ResourceManager) {

    fun getCreateDirectionDialogTitle() = resourceManager.getString(R.string.create_direction_title)
}