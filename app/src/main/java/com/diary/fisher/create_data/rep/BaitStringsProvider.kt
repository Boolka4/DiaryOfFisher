package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class BaitStringsProvider(private val resourceManager: ResourceManager) {

    fun getCreateBaitDialogTitle() = resourceManager.getString(R.string.create_bait_title)
}