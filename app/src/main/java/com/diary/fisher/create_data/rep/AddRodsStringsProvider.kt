package com.diary.fisher.create_data.rep

import com.diary.fisher.R
import com.diary.fisher.repository.resource.ResourceManager

class AddRodsStringsProvider(private val resourceManager: ResourceManager) {

    fun getCreateRodDialogTitle() = resourceManager.getString(R.string.create_rod_title)
}